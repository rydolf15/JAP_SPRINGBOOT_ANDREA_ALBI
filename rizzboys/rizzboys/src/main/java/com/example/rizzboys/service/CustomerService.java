package com.example.rizzboys.service;

import com.example.rizzboys.dto.LoginRequestDto;
import com.example.rizzboys.dto.UserDto;
import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Customer;

import java.util.List;

public interface CustomerService {

    public UserDto login(LoginRequestDto loginRequestDto) throws NotFoundException;

    public void removeCustomer(Customer c);

    void removeAll();

    List<Customer> findAllCustomers();

    Customer findById(Long id) throws NotFoundException;
}
