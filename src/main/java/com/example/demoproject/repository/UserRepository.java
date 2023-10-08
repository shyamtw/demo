package com.example.demoproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demoproject.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
    User getByUserNameAndPassword(String userName, String password);
    User getByUserName(String userName);

}
