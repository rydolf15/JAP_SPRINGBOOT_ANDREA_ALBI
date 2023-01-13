package com.example.rizzboys.dto;

import com.example.rizzboys.model.Product;
import lombok.Data;

@Data
public class ProductDto {
    Long id;
    String code;
    String name;
    String description;
    Double price;
    boolean enable;

    public Boolean getEnable() {
        return this.enable;
    }
}
