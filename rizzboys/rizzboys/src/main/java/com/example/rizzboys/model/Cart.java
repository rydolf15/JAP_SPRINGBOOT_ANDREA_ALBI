package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.cglib.core.Local;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cart")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "state")
    private String state;

    public Cart() {
    }

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<CartQty> cartQtys = new ArrayList<>();
}

