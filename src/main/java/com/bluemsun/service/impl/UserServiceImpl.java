package com.bluemsun.service.impl;

import com.bluemsun.entity.User;
import com.bluemsun.mapper.UserMapper;
import com.bluemsun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户服务实现类
 * @author: Windlinxy
 * @create: 2021-12-06 08:57
 **/
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryOne(User user) {
        User userInDatabase = null;
        try{
            userInDatabase = userMapper.selectOne(user);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return userInDatabase;
    }

    @Override
    public int changeUserPassword(User user){
        int jud = 0;
        try{
             jud = userMapper.updatePassword(user);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return jud;
    }
}
