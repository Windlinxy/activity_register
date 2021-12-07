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
    int addActivity(Activity activity);

    List<Activity> queryActivitiesByUsername(String username);

    int deleteActivityById(int id);

    int changeActivity(Activity activity);
}
