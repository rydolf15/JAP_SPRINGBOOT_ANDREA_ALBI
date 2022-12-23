package com.example.rizzboys.service;

import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Cart;

import java.util.List;

public interface CartServices {

    Cart saveCart(Cart cart);

    void removeCart(Cart cart);

    void removeAll();

    List<Cart> findAllCarts();

    Cart findById(Long id) throws NotFoundException;

}
