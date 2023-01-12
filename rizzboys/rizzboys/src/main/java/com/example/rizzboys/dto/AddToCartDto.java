package com.example.rizzboys.dto;

import lombok.Data;

@Data
public class AddToCartDto extends ProductKeysDto {
    int quantity;
}