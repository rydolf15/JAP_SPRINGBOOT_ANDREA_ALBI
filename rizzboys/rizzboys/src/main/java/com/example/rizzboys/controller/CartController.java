package com.example.rizzboys.controller;

import com.example.rizzboys.dto.AddToCartDto;
import com.example.rizzboys.dto.CartDto;
import com.example.rizzboys.dto.CustomerIdDto;
import com.example.rizzboys.dto.RemoveFromCartDto;
import com.example.rizzboys.model.Cart;
import com.example.rizzboys.repos.CartRepository;
import com.example.rizzboys.service.CartService;
import com.example.rizzboys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addToCart")
    public void addToCart(@RequestBody AddToCartDto addToCartDto){
        cartService.addToCart(addToCartDto);
    };

    @GetMapping("/displayCart")
    @ResponseBody
    public CartDto displayCart(@RequestBody CustomerIdDto customerIdDto){
        return cartService.displayCart(customerIdDto);
    };


    @DeleteMapping("/removeFromCart")
    @ResponseBody
    public CartDto removeFromCart(@RequestBody RemoveFromCartDto removeFromCartDto){
        return cartService.removeFromCart(removeFromCartDto);
    };

    @PostMapping("/goToCheckout")
    public void goToCheckout(@RequestBody CustomerIdDto customerIdDto){
        cartService.goToCheckout(customerIdDto);
    };

    @GetMapping("/findCart")
    public Cart findCart(@RequestBody CustomerIdDto customerIdDto) {
        return cartRepository.findCartForCustomer(customerIdDto.getCustomerId());
    }
}
