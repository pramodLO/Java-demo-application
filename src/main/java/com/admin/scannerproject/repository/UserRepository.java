package com.admin.scannerproject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.admin.scannerproject.user.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Long>{


@Query(value ="select * from dem2.userdetails where isactive=?", nativeQuery =true)
List<UserEntity> findAllByIsActive(byte isactive);
 
public UserEntity findUserById(Long id);

}




