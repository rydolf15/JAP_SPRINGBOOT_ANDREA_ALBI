package com.example.rizzboys.controller;

import com.example.rizzboys.dto.LoginRequestDto;
import com.example.rizzboys.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class SecurityController {

    public UserDto login(LoginRequestDto loginRequestDto){
        return null;
    };
}
