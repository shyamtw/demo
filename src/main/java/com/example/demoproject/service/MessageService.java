package com.example.demoproject.service;

import com.example.demoproject.dto.MessageDto;
import com.example.demoproject.model.Message;
import com.example.demoproject.model.Room;
import com.example.demoproject.repository.MessageRepository;
import com.example.demoproject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    MessageRepository messageRepository;

    public void create(MessageDto messageDto ){

        Room room = roomRepository.getById(messageDto.getRoomId());
        if(room!=null){
            Message message = new Message();
            message.setValue(messageDto.getValue());
            message.setRoomId(messageDto.getRoomId());
            messageRepository.save(message);
        } else {
            throw new RuntimeException("in valid room id");
        }
    }

    public List<Message> getMessages( Long roomId ){
        Room room = roomRepository.getById(roomId);
        if(room!=null){
            return  messageRepository.getByRoomId(roomId);
        } else {
            throw new RuntimeException("in valid room id");
        }
    }

    public void updateMessage( Long messageId ,MessageDto messageDto){
        Room room = roomRepository.getById(messageDto.getRoomId());

        if(room!=null){
            Message message = messageRepository.getById(messageId);
            if(message!=null){
                message.setValue(messageDto.getValue());
                message.setRoomId(messageDto.getRoomId());
                messageRepository.save(message);
            }else {
                throw new RuntimeException("in valid message id");
            }
        } else {
            throw new RuntimeException("in valid room id");
        }
    }

    public void deleteMessage(Long messageId){
        Message message = messageRepository.getById(messageId);
        if(message!=null){
            messageRepository.deleteById(messageId);
        } else {
            throw new RuntimeException("in valid message id");
        }
    }


}
