package com.example.rizzboys.service.impl;

import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Cart;
import com.example.rizzboys.repos.CartRepository;
import com.example.rizzboys.service.CartServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartServices {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
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
