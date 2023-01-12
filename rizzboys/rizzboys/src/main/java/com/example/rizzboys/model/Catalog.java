package com.example.rizzboys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Table(name = "catalog")
@Entity
public class Catalog extends Product{

/*    @ManyToOne
    public List<Product> products = new ArrayList<>();*/
    public Catalog() {
    }


}
