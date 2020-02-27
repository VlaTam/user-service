package com.tampashev.micro.user.dao;

import com.tampashev.micro.user.entities.UserEntity;

import java.util.List;

public interface UserDao {

    UserEntity save(UserEntity userEntity);
    List<UserEntity> findAll(int pageNumber);
}
