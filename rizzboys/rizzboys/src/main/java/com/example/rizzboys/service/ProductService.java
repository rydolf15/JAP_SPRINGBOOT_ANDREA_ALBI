package com.example.rizzboys.service;

import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    Product saveProduct(Product p);

    void removeProduct(Product p);

    void removeAll();

    List<Product> findAllProducts();

    Product findById(Long id) throws NotFoundException;

}