package com.example.rizzboys.service;

import com.example.rizzboys.dto.ProductDto;
import com.example.rizzboys.dto.ProductIdDto;
import com.example.rizzboys.dto.ProductKeysDto;
import com.example.rizzboys.dto.StringFilterDto;
import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Product;

import java.util.List;


public interface ProductService {


    void addProduct(ProductDto productDto);

    void changeProduct(ProductDto productDto);

    ProductDto getProductData(ProductKeysDto productKeysDto);

    List<ProductDto> searchInCatalog(String criterion);

    void deleteProduct(ProductIdDto productIdDto);

    void switchEnabledState(ProductIdDto productIdDto);

    List<Product> findAllProducts();

    Product findById(Long id) throws NotFoundException;

}