package com.example.demoproject.service;

import com.example.demoproject.dto.RoomDto;
import com.example.demoproject.model.Room;
import com.example.demoproject.model.User;
import com.example.demoproject.repository.RoomRepository;
import com.example.demoproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserRepository userRepository;

    public void create(RoomDto roomDto){

        Room room = new Room();
        room.setName(roomDto.getName());

        User user = userRepository.getByUserName(roomDto.getCreatedBy());
        if(user==null){
            throw new RuntimeException("User is not found");
        } else if(user.getRole().equals("Super Admin")){
            System.out.println(roomDto.getCreatedBy());
            room.setCreatedBy(roomDto.getCreatedBy());
            roomRepository.save(room);
        } else {
            throw new RuntimeException("Access denied to create room");
        }


    }
}
