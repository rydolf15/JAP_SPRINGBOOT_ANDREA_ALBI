package com.example.rizzboys.service;

import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.model.Product;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer c);

    void removeCustomer(Customer c);

    void removeAll();

    List<Customer> findAllCustomers();

    Customer findById(Long id) throws NotFoundException;
}
