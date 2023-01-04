package com.example.rizzboys.service.impl;

import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.ProductRepository;
import com.example.rizzboys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public void removeProduct(Product p) {
        productRepository.delete(p);
    }

    @Override
    public void removeAll() {
        productRepository.deleteAll();
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) throws NotFoundException {
        Product prod = productRepository.findById(id).orElseThrow(NotFoundException::new);
        return prod;
    }

}
