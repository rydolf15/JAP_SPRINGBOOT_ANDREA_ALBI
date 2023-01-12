package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Data
public class CartQty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartQty_id;
    private Integer quantity;


    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;

}
