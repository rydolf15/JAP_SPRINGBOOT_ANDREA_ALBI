package com.example.rizzboys.model;

import jakarta.persistence.OneToMany;

public class Catalog extends Product{

    @OneToMany
    public Product product;
    public Catalog() {
    }


}
