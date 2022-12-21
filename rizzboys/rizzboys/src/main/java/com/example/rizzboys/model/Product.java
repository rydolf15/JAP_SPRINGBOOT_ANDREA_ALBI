package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false)
    private String name;
    private String description;
    private Double price;
    private Boolean enable;
}
