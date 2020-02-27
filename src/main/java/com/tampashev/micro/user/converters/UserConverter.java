package com.tampashev.micro.user.converters;

import com.tampashev.micro.user.dto.UserDto;
import com.tampashev.micro.user.entities.UserEntity;

public interface UserConverter {

    UserEntity convertToEntity(UserDto userDto);
    UserDto convertToDto(UserEntity userEntity);
}
