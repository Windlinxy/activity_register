package com.bluemsun.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @TableName tb_user
 */
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

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}