package com.example.rizzboys.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cart_qty")
@Entity
public class CartQty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartQty_id;
    private Integer quantity;


/*
    @ManyToOne
    @JoinColumn(name = "id")
    private List<Product> products = new ArrayList<>();
*/

    @OneToMany
    private List<Cart> carts = new ArrayList<>();


    public Long getId() {
        return cartQty_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

/*
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
*/
}
