package com.bluemsun.controller;

import com.bluemsun.dto.JsonResult;
import com.bluemsun.entity.Activity;
import com.bluemsun.entity.User;
import com.bluemsun.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Autowired
    private ActivityService activityService;


    /**
     * 提交活动记录
     *
     * @date 17:36 2021/12/8
     * @param request 请求
     * @param activity 活动
     * @return com.bluemsun.dto.JsonResult<com.bluemsun.entity.Activity>
     **/
    @PostMapping(
            consumes = "application/json"
    )
    public JsonResult<Activity> submitActivity(HttpServletRequest request, @RequestBody Activity activity) {
        //获取用户信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(session.getId());
        //确保用户使用自身账号
        activity.setActivityUser(user.getUsername());
        if(activityIsRight(activity) && activityService.addActivity(activity) == 1 ){
            return new JsonResult<Activity>().ok();
        }else {
            return new JsonResult<Activity>().fail();
        }
    }

    /**
     * 获取该用户活动记录
     *
     * @date 17:36 2021/12/8
     * @param request 请求
     * @return com.bluemsun.dto.JsonResult<java.util.List<com.bluemsun.entity.Activity>>
     **/
    @GetMapping()
    public JsonResult<List<Activity>> getActivity(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(session.getId());
        List<Activity> list = activityService.queryActivitiesByUsername(user.getUsername());
        if(list != null){
            return new JsonResult<List<Activity>>().ok(list);
        }else {
            return new JsonResult<List<Activity>>().fail();
        }
    }

    /**
     * 删除活动
     *
     * @date 17:37 2021/12/8
     * @param id 活动id
     * @return com.bluemsun.dto.JsonResult<java.lang.Object>
     **/
    @DeleteMapping(value = "/{id}")
    public JsonResult<Object> deleteActivity(@PathVariable("id") int id){
       if(activityService.deleteActivityById(id) == 1){
           return new JsonResult<>().ok();
       }else {
           return new JsonResult<>().fail();
       }
    }

    /**
     * 修改活动记录
     *
     * @date 17:37 2021/12/8
     **/
    @PatchMapping( consumes = "application/json")
    public JsonResult<Activity> changActivityInfo(HttpServletRequest request, @RequestBody Activity activity) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(session.getId());
        activity.setActivityUser(user.getUsername());
        if(activityIsRight(activity) && activityService.changeActivity(activity) == 1 ){
            return new JsonResult<Activity>().ok();
        }else {
            return new JsonResult<Activity>().fail();
        }
    }

    private boolean activityIsRight(Activity activity) {
        if (activity.getActivityDate() == null) {
            return false;
        } else if (activity.getActivityName() == null) {
            return false;
        } else if (activity.getActivityMaster() == null) {
            return false;
        } else if (activity.getActivityTime() == null) {
            return false;
        } else if (activity.getActivityReferences() == null) {
            return false;
        } else if (activity.getActivityTakeWay() == null) {
            return false;
        } else {
            return activity.getActivityUser() != null;
        }
    }
}
