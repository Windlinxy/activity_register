package com.bluemsun.service.impl;

import com.bluemsun.entity.Activity;
import com.bluemsun.mapper.ActivityMapper;
import com.bluemsun.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: activity_register
 * @description: 活动服务实现类
 * @author: Windlinxy
 * @create: 2021-12-07 15:41
 **/
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper mapper;

    @Override
    public int addActivity(Activity activity) {
        int jud = 0;
        try {
            mapper.insert(activity);
            jud = 1;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return jud;
    }

    @Override
    public List<Activity> queryActivitiesByUsername(String username) {
        List<Activity> activitiesList;
        if (username == null){
            return null;
        }
        try{
            activitiesList = mapper.selectByUsername(username);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return activitiesList;
    }
    @Override
    public int deleteActivityById(int id) {
        int jud = 0;
        try{
            jud = mapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return jud;
    }
    @Override
    public int changeActivity(Activity activity) {
        int jud = 0;
        try{
            jud = mapper.updateByPrimaryKey(activity);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return jud;
    }
}
