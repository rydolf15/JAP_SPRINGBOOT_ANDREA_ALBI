package com.example.rizzboys.repos;

import com.example.rizzboys.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByProductCode(String productCode);
}

