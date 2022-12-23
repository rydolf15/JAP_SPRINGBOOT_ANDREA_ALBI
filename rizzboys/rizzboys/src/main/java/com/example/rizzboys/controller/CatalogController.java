package com.example.rizzboys.controller;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.rizzboys.dto.ProductDto;
import com.example.rizzboys.dto.ProductIdDto;
import com.example.rizzboys.dto.ProductKeysDto;
import com.example.rizzboys.dto.StringFilterDto;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/catalog")
public class CatalogController {

    @Autowired
    private ProductRepository repository;

    @ResponseBody
    @GetMapping("/search")
    public List<ProductDto> searchInCatalog(StringFilterDto stringFilterDto){
        return null;
    };

    @ResponseBody
    @GetMapping("/getdata")
    public ProductDto getProductData(ProductKeysDto productKeysDto){
        return null;
    };

    @ResponseBody
    @PostMapping("/add")
    public void addProduct(ProductDto productDto){};


    @ResponseBody
    @PostMapping("change")
    public void changeProduct(ProductDto productDto){};


    public void deleteProduct(ProductIdDto productIdDto){};

    @ResponseBody
    @PostMapping("/switchpstate")
    public void switchEnabledState(ProductIdDto productIdDto){};





    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll() {
        Spliterator<Product> products = repository.findAll().spliterator();
        return StreamSupport.stream(products, false).collect(Collectors.toList());
    }
}
