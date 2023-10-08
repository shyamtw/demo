package com.example.demoproject.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String userName;
    private String password;
    private String role;
}


