package com.example.rizzboys.repos;

import com.example.rizzboys.dto.LoginRequestDto;
import com.example.rizzboys.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Long> {


    @Query("select cu from Customer cu where cu.id = :customerId")
    Customer findCustomerById(Long customerId);

    @Query("select cu from Customer cu where cu.username = :username")
    Customer findByUsername(String username);

    @Query("select cu from Customer cu where cu.username = :password")
    Customer findCustomerByLoginCredentials(String password);
}
