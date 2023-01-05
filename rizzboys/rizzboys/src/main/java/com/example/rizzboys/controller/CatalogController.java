package com.example.rizzboys.controller;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.rizzboys.dto.ProductDto;
import com.example.rizzboys.dto.ProductIdDto;
import com.example.rizzboys.dto.ProductKeysDto;
import com.example.rizzboys.dto.StringFilterDto;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.ProductRepository;
import com.example.rizzboys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {


    @Autowired
    private ProductService productService;

    @ResponseBody
    @GetMapping("/search")
    public List<ProductDto> searchInCatalog(StringFilterDto stringFilterDto){

        return null;
    };

    @ResponseBody
    @GetMapping("/get")
    public ProductDto getProductData(ProductKeysDto productKeysDto){
        return null;
    }

    @ResponseBody
    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDto productDto){
        Product p = new Product();
        p.setId(productDto.getId());
        p.setName(productDto.getName());
        p.setDescription(productDto.getDescription());
        p.setPrice(productDto.getPrice());
        productService.saveProduct(p);
    };


    @ResponseBody
    @PostMapping("/change")
    public void changeProduct(ProductDto productDto){};


    public void deleteProduct(ProductIdDto productIdDto){};

    @ResponseBody
    @PostMapping("/switchpstate")
    public void switchEnabledState(ProductIdDto productIdDto){};





//    @ResponseBody
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Product> getAll() {
//        Spliterator<Product> products = productRepository.findAll().spliterator();
//        return StreamSupport.stream(products, false).collect(Collectors.toList());
//    }
}
