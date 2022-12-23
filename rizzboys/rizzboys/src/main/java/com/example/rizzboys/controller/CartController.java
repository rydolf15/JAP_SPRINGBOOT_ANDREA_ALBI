package com.example.rizzboys.controller;

import com.example.rizzboys.dto.AddToCartDto;
import com.example.rizzboys.dto.CartDto;
import com.example.rizzboys.dto.CustomerIdDto;
import com.example.rizzboys.dto.RemoveFromCartDto;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.repos.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CartController {

    @Autowired
    private CartRepository cartRepository;

    public void addToCart(AddToCartDto addToCartDto){};

    public CartDto displayCart(CustomerIdDto customerIdDto){
        return null;
    };

    public CartDto removeFromCart(RemoveFromCartDto removeFromCartDto){
        return null;
    };

    public void goToCheckout(CustomerIdDto customerIdDto){};


}
