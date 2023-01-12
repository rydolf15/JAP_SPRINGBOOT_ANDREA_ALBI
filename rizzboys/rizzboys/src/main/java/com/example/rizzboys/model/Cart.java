package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;
    @Column(name = "date", nullable = false, unique = true)
    private LocalDate date;
    @Column(name = "state")
    private String state;

    public Cart() {
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "cartQty_id", nullable = false, referencedColumnName = "cartQty_id")
    private CartQty cartQty;


    public Cart(Customer customer, CartQty cartQty) {
        this.customer = customer;
        this.cartQty = cartQty;
    }

    public Cart(LocalDate date, String state) {
        this.date = date;
        this.state = state;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}

