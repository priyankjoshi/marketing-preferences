package com.tg.marketingpreferences.service.impl;

import com.tg.marketingpreferences.dto.UserDto;
import com.tg.marketingpreferences.entity.User;
import com.tg.marketingpreferences.repository.UserRepository;
import com.tg.marketingpreferences.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users=userRepository.findAll();
        return mapToDto(users);
    }

    @Override
    public List<UserDto> addUsers(List<UserDto> users) {
        List<User> userList =  userRepository.saveAll(mapToEntity(users));
        return mapToDto(userList);
    }


    @PostConstruct
    public void createUserList(){
        System.out.println("Adding the dummy Users");
         List<UserDto> userDtoList =Arrays.asList(new UserDto(1,"Priyank"),new UserDto(2,"Rohit"));
         addUsers(userDtoList);
    }

    private List<UserDto> mapToDto(List<User> users) {
        return users.stream().map(user->mapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    private List<User> mapToEntity(List<UserDto> usersDto) {
        return usersDto.stream().map(userDto -> mapper.map(userDto,User.class)).collect(Collectors.toList());
    }
}
