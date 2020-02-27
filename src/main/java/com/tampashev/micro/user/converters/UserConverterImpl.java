package com.tampashev.micro.user.converters;

import com.tampashev.micro.user.dto.UserDto;
import com.tampashev.micro.user.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter{

    @Override
    public UserEntity convertToEntity(UserDto userDto){
        return new ModelMapper().map(userDto, UserEntity.class);
    }

    @Override
    public UserDto convertToDto(UserEntity userEntity){
        return new ModelMapper().map(userEntity, UserDto.class);
    }
}
