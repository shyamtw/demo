package com.example.demoproject.repository;

import com.example.demoproject.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demoproject.model.User;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Room save(Room room);

}
