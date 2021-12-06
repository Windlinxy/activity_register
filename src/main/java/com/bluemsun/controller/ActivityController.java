package com.bluemsun.controller;

import com.bluemsun.dto.JsonResult;
import com.bluemsun.entity.Activity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: activity_register
 * @description: 活动controller层
 * @author: Windlinxy
 * @create: 2021-12-06 15:23
 **/
@RestController
@RequestMapping(
        value = "/activities",
        produces = "application/json"
)
public class ActivityController {

//    @PostMapping(
//            consumes = "application/json"
//    )
//    public JsonResult<Activity> submitActivity(@RequestBody Activity activity){
//
//    }
}
