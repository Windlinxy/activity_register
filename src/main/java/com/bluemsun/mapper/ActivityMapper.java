package com.bluemsun.mapper;

import com.bluemsun.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity com.bluemsun.entity.Activity
 */
@Mapper
public interface ActivityMapper {

    int deleteByPrimaryKey(int id);

    int insert(Activity record);

    List<Activity> selectByUsername(String username);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

}
