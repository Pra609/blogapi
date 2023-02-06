package com.pragya.blogapi.services.impl;

import com.pragya.blogapi.entities.User;
import com.pragya.blogapi.exceptions.ResourceNotFoundException;
import com.pragya.blogapi.payloads.UserDto;
import com.pragya.blogapi.repositories.UserRepo;
import com.pragya.blogapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepo userRepo,ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper=modelMapper;

    }


    private  UserRepo userRepo;


    private  ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=dtoToUser(userDto);
        this.userRepo.save(user);

        return userToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(user.getPassword());
        user.setAbout(userDto.getAbout());
       // userToUserDto(user);
        userRepo.save(user);
        return this.modelMapper.map(user,UserDto.class);
    }

    @Override
    public User getUserById(Integer userId) {
        User user=this.userRepo.findById(userId).get();
                //this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

       // return this.modelMapper.map(user,UserDto.class);
        return  user;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=userRepo.findAll();

        List<UserDto> userDtos=users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        this.userRepo.delete(user);
    }

   private User dtoToUser(UserDto userDto){


        return  this.modelMapper.map(userDto,User.class);


   }

    private UserDto userToUserDto(User user){
        UserDto userDto=this.modelMapper.map(user,UserDto.class);


        return userDto;

    }


}
