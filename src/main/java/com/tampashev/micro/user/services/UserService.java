package com.tampashev.micro.user.services;

import com.tampashev.micro.user.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);
    List<UserDto> findAll(int pageNumber);
}
