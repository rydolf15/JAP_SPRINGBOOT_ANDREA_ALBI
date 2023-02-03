package com.example.rizzboys;

import com.example.rizzboys.dto.*;
import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.CartQty;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.CartQtyRepository;
import com.example.rizzboys.repos.CartRepository;
import com.example.rizzboys.repos.CustomerRespository;
import com.example.rizzboys.repos.ProductRepository;
import com.example.rizzboys.service.CartService;
import com.example.rizzboys.service.CustomerService;
import com.example.rizzboys.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class RizzboysApplicationTests {

    @Autowired
    CustomerService customerService;

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    CartQtyRepository cartQtyRepository;

    @Autowired
    CustomerRespository customerRespository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;

    @Test
    void CustomerCartProductInteraction() {
        emptyTables();

        Customer cx = new Customer();
        cx.setUsername("ledio");
        cx.setPassword("psw");
        cx.setLastName("hoxha");
        cx.setFirstName("Ledio");
        customerService.addCustomer(cx);

        cx = new Customer();
        cx.setUsername("ana");
        cx.setPassword("psw");
        cx.setLastName("ulli");
        cx.setFirstName("Ana");
        customerService.addCustomer(cx);


        //saveCart
        List<Customer> custs = customerRespository.findAll();
        Customer c1 = custs.get(0);
        Cart cart = new Cart();
        cart.setState("DRAFT");
        cart.setDate(LocalDate.now());
        cart.setCustomer(c1);
        cartService.saveCart(cart);


        //save the Product
        Product p = new Product();
        p.setCode("upg");
        p.setName("uje");
        p.setPrice(60.0);
        p.setDescription("uje pa gas");
        ProductDto productDto = new ProductDto();
        productDto.setCode(p.getCode());
        productDto.setName(p.getName());
        productDto.setPrice(p.getPrice());
        productDto.setDescription(p.getDescription());
        productService.addProduct(productDto);


        //add Product to Cart
        AddToCartDto addToCartDto = new AddToCartDto();
        addToCartDto.setIdProduct(productRepository.findByCode(productDto.getCode()).getId());
        addToCartDto.setIdCustomer(cx.getId());
        addToCartDto.setQuantity(2);
        cartService.addToCart(addToCartDto);

        //display the Cart
        CustomerIdDto customerIdDto = new CustomerIdDto();
        customerIdDto.setCustomerId(cx.getId());
        cartService.displayCart(customerIdDto);

        //remove Product From Cart
        RemoveFromCartDto removeFromCartDto = new RemoveFromCartDto();
        List<CartQty> cartQty = cartQtyRepository.findAllByProductId(productRepository.findByCode(productDto.getCode()).getId());
        removeFromCartDto.setIdQty(cartQty.get(0).getCartQty_id());
        cartService.removeFromCart(removeFromCartDto);

        //go to checkout
        cartService.goToCheckout(customerIdDto);
    }

    @Test
    void productInteractions() {
        cartQtyRepository.deleteAllInBatch();
        productRepository.deleteAllInBatch();
        //add Product
        Product p = new Product();
        p.setCode("c0");
        p.setName("cola zero");
        p.setPrice(60.0);
        p.setDescription("coca-cola zero sheqer");
        ProductDto productDto = new ProductDto();
        productDto.setCode(p.getCode());
        productDto.setName(p.getName());
        productDto.setPrice(p.getPrice());
        productDto.setDescription(p.getDescription());
        productService.addProduct(productDto);

        p.setCode("b10");
        p.setName("buke");
        p.setPrice(100.0);
        p.setDescription("buke e bardhe");
        productDto.setCode(p.getCode());
        productDto.setName(p.getName());
        productDto.setPrice(p.getPrice());
        productDto.setDescription(p.getDescription());
        productService.addProduct(productDto);



        //changeProduct
        Product pr = productRepository.findByCode(productDto.getCode());
        pr.setCode("c00");
        productDto.setCode(pr.getCode());
        productDto.setId(pr.getId());
        productService.changeProduct(productDto);

        //getProductData
        Product product = productRepository.findByCode(productDto.getCode());
        ProductKeysDto productKeysDto = new ProductKeysDto();
        productKeysDto.setIdProduct(product.getId());
        productService.getProductData(productKeysDto);

        //switchEnabledState
        ProductIdDto productIdDto = new ProductIdDto();
        productIdDto.setIdProduct(product.getId());
        productService.switchEnabledState(productIdDto);

        //searchInCatalog
        String s= "uje";
        productService.searchInCatalog(s);

        //deleteProduct
        productService.deleteProduct(productIdDto);
    }

    @Test
    void CustomerLoginAndAddition() {
        emptyTables();
        //addCustomer
        Customer cx = new Customer();
        cx.setUsername("andrea");
        cx.setPassword("1234");
        cx.setLastName("Ranxha");
        cx.setFirstName("Andrea");
        customerService.addCustomer(cx);

        //login
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setUsername(cx.getUsername());
        loginRequestDto.setPassword(cx.getPassword());
        customerService.login(loginRequestDto);
    }



    private void emptyTables() {
        cartQtyRepository.deleteAllInBatch();
        productRepository.deleteAllInBatch();
        cartRepository.deleteAllInBatch();
        customerRespository.deleteAllInBatch();
    }

}
