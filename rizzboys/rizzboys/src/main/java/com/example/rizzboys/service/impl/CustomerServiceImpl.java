package com.example.rizzboys.service.impl;

import com.example.rizzboys.dto.LoginRequestDto;
import com.example.rizzboys.dto.UserDto;
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

    //ASK
    @Override
    public UserDto login(LoginRequestDto loginRequestDto) throws NotFoundException {
        Customer customer = new Customer();
        try {
            customer = customerRespository.findCustomerByLoginCredentials(loginRequestDto.getPassword());
        } catch(NotFoundException notFoundException) {
            System.out.println("Username or password is incorrect!");
        }
        UserDto userDto = new UserDto();
        userDto.setId(customer.getId());
        userDto.setUsername(customer.getUsername());
        userDto.setFirstName(customer.getFirstName());
        userDto.setLastName(customer.getLastName());
        return userDto;
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
