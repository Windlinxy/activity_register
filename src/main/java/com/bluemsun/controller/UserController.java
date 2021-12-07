package com.bluemsun.controller;

import com.bluemsun.dto.JsonResult;
import com.bluemsun.dto.UserPasswordJud;
import com.bluemsun.entity.User;
import com.bluemsun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description: 用户controller
 * @author: Windlinxy
 * @create: 2021-12-05 15:42
 **/
@RestController
@RequestMapping(
        value = "/users",
        produces = "application/json"
)
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 用户登录方法
     *
     * @param user 用户（账号，密码）
     * @date 17:40 2021/12/5
     **/
    @PostMapping(value = "/login", consumes = "application/json")
    public JsonResult<User> login(@RequestBody User user, HttpServletRequest request) {
        if(user.getUsername() == null || user.getPassword() == null){
            return new JsonResult<User>().fail("登录失败");
        }
        User userInDatabase = userService.queryOne(user);
        if (userInDatabase != null){
            HttpSession session = request.getSession();
            System.out.println(session.getId());
            session.setAttribute(session.getId(), user.getPassword());
            user.setPassword(null);
            return new JsonResult<User>().ok(user);

        } else {
            return new JsonResult<User>().fail("登录失败");
        }
    }

    /**
     * 修改用户信息（部分）
     *
     * @param request 请求
     * @param user    用户（需要修改的信息）
     * @date 17:30 2021/12/6
     **/
    @PatchMapping( consumes = "application/json")
    public JsonResult<User> changUserPassword(HttpServletRequest request,@RequestBody UserPasswordJud user) {
        if(user.getUsername() == null || user.getOldPassword() ==null || user.getNewPassword() == null){
            System.out.println(1);
            return new JsonResult<User>().fail("失败");
        }
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        String oldPassword = (String)session.getAttribute(session.getId());
        System.out.println(user);
        System.out.println(oldPassword);
        if(oldPassword != null && oldPassword.equals(user.getOldPassword())){
            User user1 = new User(user.getUsername(),user.getNewPassword());
            if(userService.changeUserPassword(user1) == 1){
                session.setAttribute(user.getUsername(), user1);
                user1.setPassword(null);
                return new JsonResult<User>().ok(user1);
            }else {
                System.out.println(2);
                return new JsonResult<User>().fail("失败");
            }
        }else{
            System.out.println(3);
            return new JsonResult<User>().fail("失败");
        }
    }
}
