package com.example.rizzboys.controller;

import java.util.List;

import com.example.rizzboys.dto.ProductDto;
import com.example.rizzboys.dto.ProductIdDto;
import com.example.rizzboys.dto.ProductKeysDto;
import com.example.rizzboys.dto.StringFilterDto;
import com.example.rizzboys.service.CartService;
import com.example.rizzboys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @ResponseBody
    @GetMapping("/searchInCatalog")
    public List<ProductDto> searchInCatalog(@RequestBody StringFilterDto stringFilterDto){
        return productService.searchInCatalog(stringFilterDto.getCriterion());
    }

    @ResponseBody
    @GetMapping("/getProductData")
    public ProductDto getProductData(@RequestBody ProductKeysDto productKeysDto){
        return productService.getProductData(productKeysDto);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public void addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
    };

    @PutMapping("/changeProduct")
    public void changeProduct(@RequestBody ProductDto productDto){
        productService.changeProduct(productDto);
    };

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody ProductIdDto productIdDto){
        productService.deleteProduct(productIdDto);
    };

    @PutMapping("/switchpstate")
    public void switchEnabledState(@RequestBody ProductIdDto productIdDto){
        productService.switchEnabledState(productIdDto);
    };

}
