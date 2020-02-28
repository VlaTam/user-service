package com.tampashev.micro.user.dao.repositories;

import com.tampashev.micro.user.entities.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    @Modifying
    @Query("UPDATE UserEntity SET lastVisitDate = :lastVisit")
    void updateLastVisitDate(Date lastVisit);

    boolean existsByUserNameAndPassword(String userName, String password);
}
