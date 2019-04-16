package com.springboot.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.demo.dao.UserEntityDao;
import com.springboot.demo.entity.UserEntity;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityDao userEntityDao;

    @Override

    public int insertUserEntity(UserEntity userEntity) {
        int i = userEntityDao.insertUserEntity(userEntity);
        return i;
    }

    @Override
    public UserEntity selectUserEntity(UserEntity userEntity) {
        UserEntity userEntity1 = userEntityDao.selectUserEntity(userEntity);
        return userEntity1;
    }

    @Override
    public PageInfo<UserEntity> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserEntity> userEntities = userEntityDao.selectUserList();
        PageInfo pageInfo = new PageInfo(userEntities);
        return pageInfo;
    }
}
