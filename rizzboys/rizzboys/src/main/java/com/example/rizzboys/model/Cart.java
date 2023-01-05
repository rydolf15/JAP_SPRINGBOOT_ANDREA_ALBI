package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date", nullable = false, unique = true)
    private LocalDate date;
    @Column(name = "state")
    private String state;


    public Cart() {
    }
    @OneToMany(mappedBy = "cart")
    List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "cart")
    List<CartQty> cartQties = new ArrayList<>();


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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<CartQty> getCartQties() {
        return cartQties;
    }

    public void setCartQties(List<CartQty> cartQties) {
        this.cartQties = cartQties;
    }
}

