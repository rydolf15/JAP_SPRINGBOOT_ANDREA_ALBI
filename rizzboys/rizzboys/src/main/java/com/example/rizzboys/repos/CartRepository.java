package com.example.rizzboys.repos;

import com.example.rizzboys.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select ca from Cart ca where ca.customer.id = :idCustomer and ca.state = 'DRAFT'")
    Cart findCartForCustomer(Long idCustomer);

}

