package com.example.rizzboys.service.impl;

import com.example.rizzboys.dto.*;
import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.CartQty;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.CartQtyRepository;
import com.example.rizzboys.repos.ProductRepository;
import com.example.rizzboys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartQtyRepository cartQtyRepository;

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
    public List<ProductDto> searchInCatalog(String criterion) {
        String s = "%" + criterion + "%";
        var found = productRepository.searchInCatalog(s);
        List<ProductDto> foundList = new ArrayList<>();
        for(Product p: found){
            ProductDto productDto = new ProductDto();
            productDto.setDescription(p.getDescription());
            productDto.setName(p.getName());
            productDto.setCode(p.getCode());
            productDto.setPrice(p.getPrice());
            productDto.setEnable(p.getEnable());
            productDto.setId(p.getId());
            foundList.add(productDto);
        }
        return foundList;
    }


    @Override
    public void deleteProduct(ProductIdDto productIdDto) throws NotFoundException{
        Product p = productRepository.findProductById(productIdDto.getIdProduct());
        CartQty cartQty = new CartQty();
        List<CartQty> cartQtiesOfProduct = cartQtyRepository.findAllByProductId(productIdDto.getIdProduct());
        for(CartQty qty: cartQtiesOfProduct) {
            cartQtyRepository.delete(qty);
        }
        //cartQtyRepository.deleteCarQtyByProductId(productIdDto.getIdProduct());
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
