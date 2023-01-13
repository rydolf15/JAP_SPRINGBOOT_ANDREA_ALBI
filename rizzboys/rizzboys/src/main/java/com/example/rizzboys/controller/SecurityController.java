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
    public UserDto login(LoginRequestDto loginRequestDto){
        return customerService.login(loginRequestDto);
    };

    @PostMapping("/addCustomer")
    @ResponseBody
    public UserDto addCustomer(@RequestBody UserDto dto){
        Customer cx = new Customer();
        cx.setFirstName(dto.getFirstName());
        cx.setLastName(dto.getLastName());
        cx.setPassword("1234");
        cx.setUsername(dto.getUsername());
        var c2 =  customerService.saveCustomer(cx);
        UserDto ud = new UserDto();
        ud.setId(c2.getId());
        ud.setFirstName(c2.getFirstName());
        ud.setLastName(c2.getLastName());
        ud.setUsername(c2.getUsername());
        return ud;
    }
}
