package com.example.rizzboys.service.impl;

import com.example.rizzboys.dto.ProductDto;
import com.example.rizzboys.dto.ProductIdDto;
import com.example.rizzboys.dto.ProductKeysDto;
import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.ProductRepository;
import com.example.rizzboys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void addProduct(ProductDto productDto) {
        Product p = new Product();
        p.setId(productDto.getId());
        p.setCode(productDto.getCode());
        p.setName(productDto.getName());
        p.setDescription(productDto.getDescription());
        p.setPrice(productDto.getPrice());
        p.setEnable(productDto.getEnable());
        productRepository.save(p);
    }


    @Override
    public void changeProduct(ProductDto productDto) {
        Product p = productRepository.findProductById(productDto.getId());
        p.setName(productDto.getName());
        p.setCode(productDto.getCode());
        p.setDescription(productDto.getDescription());
        p.setPrice(productDto.getPrice());
        p.setEnable(productDto.getEnable());
        productRepository.save(p);
    }

    @Override
    public ProductDto getProductData(ProductKeysDto productKeysDto) {
        Product product = productRepository.findProductById(productKeysDto.getIdProduct());
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setCode(product.getCode());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setEnable(product.getEnable());
        return productDto;
    }

    @Override
    public void deleteProduct(ProductIdDto productIdDto) {
        Product p = productRepository.findProductById(productIdDto.getIdProduct());
        productRepository.delete(p);
    }

    @Override
    public void switchEnabledState(ProductIdDto productIdDto) {
        Product p = productRepository.findProductById(productIdDto.getIdProduct());
        if(p.getEnable() == false)
            p.setEnable(true);
        else
            p.setEnable(false);
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
