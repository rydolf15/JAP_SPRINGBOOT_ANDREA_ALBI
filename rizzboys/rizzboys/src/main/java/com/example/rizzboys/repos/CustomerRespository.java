package com.example.rizzboys.repos;

import com.example.rizzboys.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<Customer, Long> {
}
