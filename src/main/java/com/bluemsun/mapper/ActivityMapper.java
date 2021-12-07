package com.bluemsun.mapper;

import com.bluemsun.entity.Activity;

import java.util.List;

/**
 * @Entity com.bluemsun.entity.Activity
 */
public interface ActivityMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Activity record);

    List<Activity> selectByUsername(String username)


    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

}
