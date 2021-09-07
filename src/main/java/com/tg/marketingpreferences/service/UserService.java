package com.tg.marketingpreferences.service;

import com.tg.marketingpreferences.dto.UserDto;
import com.tg.marketingpreferences.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<UserDto> getUsers();
    List<UserDto> addUsers(List<UserDto> users);
}
