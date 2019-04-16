package com.springboot.demo.service;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.entity.UserEntity;

public interface UserService {

    int insertUserEntity(UserEntity userEntity);

    UserEntity selectUserEntity(UserEntity userEntity);

    PageInfo<UserEntity> findAllUser(int pageNum, int pageSize);
}
