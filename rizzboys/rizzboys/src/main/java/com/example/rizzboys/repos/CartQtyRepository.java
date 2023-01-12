package com.example.rizzboys.repos;

import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.CartQty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartQtyRepository extends JpaRepository<CartQty, Long> {

}

