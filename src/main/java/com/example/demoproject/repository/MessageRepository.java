package com.example.demoproject.repository;

import com.example.demoproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message save(Message message);
    List<Message> getByRoomId(Long roomId);
    Message getById(Long id);
    void deleteById(Long id);


}