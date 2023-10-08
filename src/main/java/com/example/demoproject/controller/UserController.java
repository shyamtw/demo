package com.example.demoproject.controller;

import com.example.demoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoproject.dto.UserDto;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public String register(@RequestBody UserDto userDto){
        userService.register(userDto);
        return "user registered successfully";
    }
    @GetMapping("/login")
    public String login(@RequestBody UserDto userDto){
        userService.login(userDto);
        return "user logged in successfully";
    }
}
