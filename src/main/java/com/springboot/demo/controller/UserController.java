package com.springboot.demo.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.springboot.demo.CommonEnum;
import com.springboot.demo.entity.ResponseData;
import com.springboot.demo.entity.UserEntity;
import com.springboot.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller()
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private Gson gson;

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/insertEntity")
    public ResponseData insertEntity(UserEntity userEntity){
        logger.info("新增用户的内容为:" + gson.toJson(userEntity));
        ResponseData responseData = new ResponseData();
        int i = userService.insertUserEntity(userEntity);
        logger.info("添加用户，用户信息:" + userEntity.toString());
        if(i < 1){
            logger.info("用户添加失败");
            responseData.setCode(CommonEnum.FILE.getCode());
            responseData.setMsg(CommonEnum.FILE.getMsg());
            return responseData;
        }
        logger.info("添加用户成功");
        responseData.setCode(CommonEnum.SUCCESS.getCode());
        responseData.setMsg(CommonEnum.SUCCESS.getMsg());
        return responseData;
    }

    @ResponseBody
    @PostMapping("/getUser")
    public ResponseData selectUserEntity(UserEntity userEntity){
        ResponseData responseData = new ResponseData();
        UserEntity userEntity1 = userService.selectUserEntity(userEntity);
        if(userEntity == null){
            logger.info("查询用户失败");
            responseData.setCode(CommonEnum.FILE.getCode());
            responseData.setMsg(CommonEnum.FILE.getMsg());
            return responseData;
        }
        logger.info("查询用户成功");
        responseData.setCode(CommonEnum.SUCCESS.getCode());
        responseData.setMsg(CommonEnum.SUCCESS.getMsg());
        responseData.setData(userEntity);
        return responseData;
    }

    @ResponseBody
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public ResponseData selectUserList(){
        ResponseData responseData = new ResponseData();
        PageInfo<UserEntity> allUser = userService.findAllUser(0, 100);
        if(allUser == null){
            logger.info("查询用户列表失败");
            responseData.setCode(CommonEnum.FILE.getCode());
            responseData.setMsg(CommonEnum.FILE.getMsg());
            return responseData;
        }
        logger.info("查询用户列表成功");
        responseData.setCode(CommonEnum.SUCCESS.getCode());
        responseData.setMsg(CommonEnum.SUCCESS.getMsg());
        responseData.setData(allUser);
        return responseData;
    }


}
