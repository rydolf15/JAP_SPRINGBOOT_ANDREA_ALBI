package com.example.rizzboys.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {
    Long id;
    Long idCustomer;
    List<CartEntryDto> content;

}
