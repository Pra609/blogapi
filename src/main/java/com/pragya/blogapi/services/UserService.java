package com.pragya.blogapi.services;

import com.pragya.blogapi.entities.User;
import com.pragya.blogapi.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Integer userId );
    User getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);

}
