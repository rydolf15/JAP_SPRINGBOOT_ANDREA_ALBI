package com.example.rizzboys.controller;

import java.util.List;

import com.example.rizzboys.dto.ProductDto;
import com.example.rizzboys.dto.ProductIdDto;
import com.example.rizzboys.dto.ProductKeysDto;
import com.example.rizzboys.dto.StringFilterDto;
import com.example.rizzboys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {


    @Autowired
    private ProductService productService;



    @ResponseBody
    @GetMapping("/search")
    public List<ProductDto> searchInCatalog(@RequestBody StringFilterDto stringFilterDto){

        return null;
    };

    @ResponseBody
    @GetMapping("/get")
    public ProductDto getProductData(@RequestBody ProductKeysDto productKeysDto){
        return productService.getProductData(productKeysDto);
    }

    @PutMapping("/add")
    public void addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
    };



    @PostMapping("/changeProduct")
    public void changeProduct(@RequestBody ProductDto productDto){

        productService.changeProduct(productDto);
    };

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody ProductIdDto productIdDto){

        productService.deleteProduct(productIdDto);
    };


    @PostMapping("/switchpstate")
    public void switchEnabledState(ProductIdDto productIdDto){
        productService.switchEnabledState(productIdDto);
    };





//    @ResponseBody
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Product> getAll() {
//        Spliterator<Product> products = productRepository.findAll().spliterator();
//        return StreamSupport.stream(products, false).collect(Collectors.toList());
//    }
}
