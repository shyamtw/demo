package com.example.demoproject.service;
import com.example.demoproject.dto.UserDto;
import com.example.demoproject.model.User;
import com.example.demoproject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void register(UserDto userDto){

        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        userRepository.save(user);
    }
    public void login(UserDto userDto){
        User user = userRepository.getByUserNameAndPassword(userDto.getUserName(),userDto.getPassword());
        if(user==null){
            throw new RuntimeException("User is not found");
        }
    }
}
