package com.example.rizzboys.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(nullable = false, unique = true)
    protected String code;
    @Column(nullable = false)
    protected String name;
    protected String description;
    protected Double price;
    protected Boolean enable;


    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    protected List<CartQty> products = new ArrayList<>();

    public Product() {
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}

