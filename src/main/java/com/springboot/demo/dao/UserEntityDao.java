package com.springboot.demo.dao;

import com.springboot.demo.entity.UserEntity;

import java.util.List;

public interface UserEntityDao {

    int insertUserEntity(UserEntity userEntity);

    UserEntity selectUserEntity(UserEntity userEntity);

    List<UserEntity> selectUserList();
}
