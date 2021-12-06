package com.bluemsun.service;

import com.bluemsun.entity.User;
import org.springframework.stereotype.Service;

/**
 * @program: to_login
 * @description: 用户服务
 * @author: Windlinxy
 * @create: 2021-12-05 17:42
 **/

public interface UserService {
    /**
     * 用户登录服务
     *
     * @date 9:05 2021/12/6
     * @param user 用户输入
     * @return com.bluemsun.entity.User 数据库用户
     **/
    User queryOne(User user);
    /**
     * 修改密码
     *
     * @date 16:44 2021/12/6
     * @param user 用户（修改后的密码）
     * @return int 是否成功
     **/
    int changeUserPassword(User user);
}
