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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date", nullable = false, unique = true)
    private LocalDate date;
    @Column(name = "state")
    private String state;


    public Cart() {
    }
    @OneToMany(mappedBy = "cart")
    List<Cart> students = new ArrayList<>();

    public Cart(LocalDate date, String state) {
        this.date = date;
        this.state = state;
    }
}

