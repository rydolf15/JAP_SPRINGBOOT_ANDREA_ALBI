package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Table(name = "customer")
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Cart> carts = new ArrayList<>();

    public Customer(String firstname, String lastname, String username, String password) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.username = username;
        this.password = password;
    }


    public Customer() {}
}

