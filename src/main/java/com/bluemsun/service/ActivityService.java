package com.bluemsun.service;

import com.bluemsun.entity.Activity;

import java.util.List;

/**
 * @program: activity_register
 * @description: 活动服务
 * @author: Windlinxy
 * @create: 2021-12-07 15:40
 **/
public interface ActivityService {
    /**
     * 增加活动记录
     *
     * @date 18:10 2021/12/8
     * @param activity 活动记录
     * @return int 返回成功与否（1成功、0失败）
     **/
    int addActivity(Activity activity);

    /**
     * 查询活动记录
     *
     * @date 18:11 2021/12/8
     * @param username 账号
     * @return java.util.List<com.bluemsun.entity.Activity> 数据
     **/
    List<Activity> queryActivitiesByUsername(String username);

    /**
     * 删除活动
     *
     * @date 18:11 2021/12/8
     * @param id 活动id
     * @return int id
     **/
    int deleteActivityById(int id);

    /**
     * 修改活动记录
     *
     * @date 18:11 2021/12/8
     * @param activity 活动
     * @return int 返回成功与否（1成功、0失败）、
     **/
    int changeActivity(Activity activity);
}
