package com.bluemsun.mapper;

import com.bluemsun.entity.Activity;

/**
 * @Entity com.bluemsun.entity.Activity
 */
public interface ActivityMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

}
