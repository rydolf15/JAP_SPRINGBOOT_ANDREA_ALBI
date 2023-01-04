package com.example.rizzboys.dto;

import java.util.List;

public class CartDto {
    Long id;
    Long idCustomer;
    List<CartEntryDto> content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<CartEntryDto> getContent() {
        return content;
    }

    public void setContent(List<CartEntryDto> content) {
        this.content = content;
    }
}
