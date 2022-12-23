package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CartQty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product products;
}
