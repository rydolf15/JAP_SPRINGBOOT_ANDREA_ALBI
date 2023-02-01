package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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


    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    public Cart getCart() {
        return cart;
    }
}
