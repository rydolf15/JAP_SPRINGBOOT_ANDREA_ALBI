package com.example.rizzboys.model;

import com.example.rizzboys.dto.ProductDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Data
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false, unique = true)
    protected String code;
    @Column(nullable = false)
    protected String name;
    protected String description;
    protected Double price;
    protected Boolean enable;

    @OneToMany(mappedBy = "product")
    protected List<CartQty> qties = new ArrayList<>();


    public Product(ProductDto productDto){
        this.code = productDto.getCode();
        this.name = productDto.getName();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.enable = productDto.getEnabled();
    }


    public Product() {
    }

}

