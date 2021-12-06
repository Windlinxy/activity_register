package com.bluemsun.dto;

import lombok.Data;

/**
 * @program: activity_register
 * @description: 用户修改密码
 * @author: Windlinxy
 * @create: 2021-12-06 16:55
 **/
@Data
public class UserPasswordJud {
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
    private String oldPassword;

    private String newPassword;

    public UserPasswordJud() {
    }

    @Override
    public String toString() {
        return "UserPasswordJud{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
