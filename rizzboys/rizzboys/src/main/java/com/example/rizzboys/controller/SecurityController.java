package com.example.rizzboys.controller;

import com.example.rizzboys.dto.LoginRequestDto;
import com.example.rizzboys.dto.UserDto;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/login")
    @ResponseBody
    public UserDto login(LoginRequestDto loginRequestDto){
        return customerService.login(loginRequestDto);
    };

    @PostMapping("/addCustomer")
    @ResponseBody
    public UserDto addCustomer(@RequestBody Customer c) {
        return customerService.addCustomer(c);
    }

}
