package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class CartQty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer quantity;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Product> products = new ArrayList<>();

    @OneToMany
    private List<Cart> carts = new ArrayList<>();


}
