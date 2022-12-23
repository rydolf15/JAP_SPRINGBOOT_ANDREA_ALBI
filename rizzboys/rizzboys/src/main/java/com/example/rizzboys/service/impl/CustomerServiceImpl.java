package com.example.rizzboys.service.impl;

import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.CustomerRespository;
import com.example.rizzboys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRespository customerRespository;

    @Override
    public Customer saveCustomer(Customer c) {
        return customerRespository.save(c);
    }

    @Override
    public void removeCustomer(Customer c) {
        customerRespository.delete(c);
    }

    @Override
    public void removeAll() {
        customerRespository.deleteAll();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRespository.findAll();
    }

    @Override
    public Customer findById(Long id) throws NotFoundException {
        Customer c = customerRespository.findById(id)
                .orElseThrow(NotFoundException::new);
        return c;
    }
}
