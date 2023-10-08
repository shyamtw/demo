package com.example.demoproject.controller;

import com.example.demoproject.dto.MessageDto;
import com.example.demoproject.model.Message;
import com.example.demoproject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;
    @PostMapping
    public String create(@RequestBody MessageDto messageDto){
        messageService.create(messageDto);
        return "room created successfully";
    }

    @GetMapping
    public ResponseEntity<List<Message>> getMessages(@RequestParam(required = true) Long roomId){
        List<Message> response = messageService.getMessages(roomId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public String updateMessage(@PathVariable(value = "id") Long messageId, @RequestBody MessageDto messageDto){
        messageService.updateMessage(messageId, messageDto);
        return "message updated successfully";
    }

    @DeleteMapping
    public String deleteMessage(@RequestParam Long messageId) {
        messageService.deleteMessage(messageId);
        return "message deleted successfully";

    }

}
