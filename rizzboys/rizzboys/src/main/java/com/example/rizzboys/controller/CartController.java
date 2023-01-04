package com.example.rizzboys.controller;

import com.example.rizzboys.dto.AddToCartDto;
import com.example.rizzboys.dto.CartDto;
import com.example.rizzboys.dto.CustomerIdDto;
import com.example.rizzboys.dto.RemoveFromCartDto;
import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.repos.CartRepository;
import com.example.rizzboys.service.CartService;
import com.example.rizzboys.service.ProductService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addToCart")
    @ResponseBody
    public void addToCart(@RequestBody AddToCartDto addToCartDto){




    };

    public CartDto displayCart(CustomerIdDto customerIdDto){
        return null;
    };

    public CartDto removeFromCart(RemoveFromCartDto removeFromCartDto){
        return null;
    };

    public void goToCheckout(CustomerIdDto customerIdDto){};


}
