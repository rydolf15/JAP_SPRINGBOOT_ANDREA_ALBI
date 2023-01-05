package com.example.rizzboys.service;

import com.example.rizzboys.dto.LoginRequestDto;
import com.example.rizzboys.dto.StringFilterDto;
import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.CustomerRespository;

import java.util.List;

public interface CustomerService {


    public Customer saveCustomer(Customer c);

    public String login(LoginRequestDto loginRequestDto) throws NotFoundException;

    public void removeCustomer(Customer c);

    void removeAll();

    List<Customer> findAllCustomers();

    Customer findById(Long id) throws NotFoundException;
}
