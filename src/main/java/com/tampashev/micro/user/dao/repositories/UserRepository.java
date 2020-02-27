package com.tampashev.micro.user.dao.repositories;

import com.tampashev.micro.user.entities.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
}
