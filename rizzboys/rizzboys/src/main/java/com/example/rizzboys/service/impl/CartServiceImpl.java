package com.example.rizzboys.service.impl;

import com.example.rizzboys.dto.*;
import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.CartQty;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.CartQtyRepository;
import com.example.rizzboys.repos.CartRepository;
import com.example.rizzboys.repos.CustomerRespository;
import com.example.rizzboys.repos.ProductRepository;
import com.example.rizzboys.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartQtyRepository cartQtyRepository;

    @Autowired
    CustomerRespository customerRespository;


    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void addToCart(AddToCartDto addToCartDto) throws NotFoundException{
        // retrieve product
        Product product = productRepository.findById(addToCartDto.getIdProduct())
                .orElse(null);
        // TODO: retrieve cart
        //the attributes idCustomer in ProductKeysDto are made protected so AddToCartDto can access
        Cart dbCart = cartRepository.findCartForCustomer(addToCartDto.getIdCustomer());
        // if cart is empty create
        if (dbCart == null){
            Customer customer = customerRespository.findById(addToCartDto.getIdCustomer())
                    .orElseThrow(()-> new NotFoundException());
            dbCart = new Cart();
            // fill it
            dbCart.setDate(LocalDate.now());
            dbCart.setState("DRAFT");
            dbCart.setCustomer(customer);
        }
        // now add the product to the cart ...
        CartQty cq = new CartQty();
        cq.setQuantity(addToCartDto.getQuantity());
        cq.setProduct(product);
        cq.setCart(dbCart);

        product.getQties().add(cq);

        // get all products associated to dbCart and add a new one checking if it already exists or not in the cart
        dbCart.getCartQtys().add(cq);
        cartRepository.save(dbCart);
        cartQtyRepository.save(cq);
        productRepository.save(product);
    }

    @Override
    public CartDto displayCart(CustomerIdDto customerIdDto) {
        Cart c = cartRepository.findCartForCustomer(customerIdDto.getCustomerId());
        CartDto cartDto = new CartDto();
        cartDto.setId(c.getId());
        cartDto.setIdCustomer(c.getCustomer().getId());
        List<CartEntryDto> content = new ArrayList<>();
        List<CartQty> cartQties = c.getCartQtys();

        for(CartQty cartQty : cartQties) {
            CartEntryDto cartEntryDto = new CartEntryDto(cartQty);
            content.add(cartEntryDto);
        }
        cartDto.setContent(content);
        return cartDto;
    }

    @Override
    public CartDto removeFromCart(RemoveFromCartDto removeFromCartDto) {
        //retrieve the cartQty
        CartQty cartQty = cartQtyRepository.findCartQtyById(removeFromCartDto.getIdQty());

        //find the customer to whom it belongs
        Customer customer = customerRespository.findCustomerById(cartQtyRepository.findCartQtyById(cartQty.getCartQty_id())
                                                                    .getCart().getCustomer().getId());
        //find the cart to whom it belongs
        Cart cart = cartRepository.findCartForCustomer(customer.getId());

        //retrieve all the cartQties
        List<CartQty> cartQties = cart.getCartQtys();

        //remove the cartQty with the specified id
        cartQties.remove(cartQty);

        //return the CartDto object after filling all its attributes
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setIdCustomer(customer.getId());
        List<CartEntryDto> content = new ArrayList<>();
        CartEntryDto cartEntryDto;
        for(CartQty cartQty1 : cartQties) {
            cartEntryDto = new CartEntryDto(cartQty1);
            content.add(cartEntryDto);
        }
        cartDto.setContent(content);
        return cartDto;


    }


    //ASK
    @Override
    public void goToCheckout(CustomerIdDto customerIdDto) {
        Cart c = cartRepository.findCartForCustomer(customerIdDto.getCustomerId());
        c.setState("CHECKOUT");
        cartRepository.save(c);
    }

    @Override
    public List<ProductDto> searchInCatalog(String criterion) {
        String s = "%" + criterion + "%";
        var found = productRepository.searchInCatalog(s);
        List<ProductDto> foundList = new ArrayList<>();
        for(Product p: found){
            ProductDto productDto = new ProductDto();
            productDto.setDescription(p.getDescription());
            productDto.setName(p.getName());
            productDto.setCode(p.getCode());
            productDto.setPrice(p.getPrice());
            productDto.setEnable(p.getEnable());
            productDto.setId(p.getId());
            foundList.add(productDto);
        }
        return foundList;
    }

    @Override
    public void removeCart(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public void removeAll() {
        cartRepository.deleteAll();
    }

    @Override
    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(Long id) throws NotFoundException {
        Cart c = cartRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        return c;
    }
}
