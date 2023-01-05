package com.example.rizzboys.dto;

import com.example.rizzboys.model.Product;

public class ProductDto {
    Long id;
    String code;
    String name;
    String description;
    Double price;
    boolean enabled;

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setCode(product.getCode());
        this.setName(product.getName());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setEnabled(product.getEnable());
    }


    public ProductDto(String code, String name, String description, Double price, boolean enabled) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
