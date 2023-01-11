package com.example.rizzboys.model;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class Catalog extends Product{

    @ManyToOne
    public List<Product> products = new ArrayList<>();
    public Catalog() {
    }


}
