package com.example.rizzboys.service;

import com.example.rizzboys.dto.*;
import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.Product;

import java.util.List;

public interface CartService {

    Cart saveCart(Cart cart);

    void addToCart(AddToCartDto addToCartDto);

    CartDto displayCart(CustomerIdDto customerIdDto);

    CartDto removeFromCart(RemoveFromCartDto removeFromCartDto);

    void goToCheckout(CustomerIdDto customerIdDto);

    void removeCart(Cart cart);

    void removeAll();

    List<Cart> findAllCarts();

    Cart findById(Long id) throws NotFoundException;

}
