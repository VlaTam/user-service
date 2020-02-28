package com.tampashev.micro.user.services;

import com.tampashev.micro.user.converters.UserConverter;
import com.tampashev.micro.user.dao.UserDao;
import com.tampashev.micro.user.dto.UserDto;
import com.tampashev.micro.user.entities.UserEntity;
import com.tampashev.micro.user.holders.UserProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserConverter converter;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserProps userProps;

    @Override
    public UserDto save(UserDto userDto) {
        UserEntity userEntity = converter.convertToEntity(userDto);
        userEntity = userDao.save(userEntity);
        return converter.convertToDto(userEntity);
    }

    @Override
    public List<UserDto> findAll(int pageNumber) {
        int pageSize = userProps.getPageSize();
        return userDao.findAll(pageNumber, pageSize)
                                .stream()
                                .map(userEntity -> converter.convertToDto(userEntity))
                                .collect(Collectors.toList());
    }

    @Override
    public boolean isExisted(String userName, String password){
        return userDao.isExisted(userName, password);
    }
}
