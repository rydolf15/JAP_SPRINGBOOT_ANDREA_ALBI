package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date", nullable = false, unique = true)
    private LocalDate date;
    @Column(name = "quantity")
    private String availableQuantity;
}
