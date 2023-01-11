package com.example.rizzboys.service.impl;

import com.example.rizzboys.dto.AddToCartDto;
import com.example.rizzboys.dto.ProductKeysDto;
import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.CartRepository;
import com.example.rizzboys.repos.ProductRepository;
import com.example.rizzboys.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;


    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void addToCart(AddToCartDto addToCartDto) {
        // retrieve product
        Product product = productRepository.findById(addToCartDto.getIdProduct())
                .orElse(null);
        //TODO: retrieve cart
        Cart dbCart =
        // if cart is empty create
        if (dbCart == null){
            dbCart = new Cart();
            // fill it
        }
        // get all products associated to dbCart and add a new one checking if it already exists or not in the cart
        cartRepository.save(dbCart);
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
