package com.example.rizzboys.repos;

import com.example.rizzboys.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Long> {

    Customer findByUsername(String username);
}
