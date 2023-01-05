package com.example.rizzboys.service.impl;

import com.example.rizzboys.dto.LoginRequestDto;
import com.example.rizzboys.dto.StringFilterDto;
import com.example.rizzboys.exception.NotFoundException;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.repos.CustomerRespository;
import com.example.rizzboys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRespository customerRespository;

    @Override
    public String login(LoginRequestDto loginRequestDto) throws NotFoundException {
        Customer customer = customerRespository.findByUsername(loginRequestDto.getUsername());
        return "Welcome";
    }

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
