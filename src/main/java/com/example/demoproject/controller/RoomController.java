package com.example.demoproject.controller;

import com.example.demoproject.dto.RoomDto;
import com.example.demoproject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoproject.dto.UserDto;


@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;
    @PostMapping
    public String create(@RequestBody RoomDto roomDto){
        roomService.create(roomDto);
        return "room created successfully";
    }

}
