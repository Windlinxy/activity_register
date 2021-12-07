package com.bluemsun.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 用户实体类
 *
 * @author: windlinxy
 * @create: 2021-12-05 15:42
 **/
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}