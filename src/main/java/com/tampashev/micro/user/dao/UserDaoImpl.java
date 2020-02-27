package com.tampashev.micro.user.dao;

import com.tampashev.micro.user.dao.repositories.UserRepository;
import com.tampashev.micro.user.entities.UserEntity;
import com.tampashev.micro.user.holders.UserProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProps userProps;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findAll(int pageNumber) {
        int pageSize = userProps.getPageSize();
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<UserEntity> page = userRepository.findAll(pageable);
        return page.getContent();
    }
}
