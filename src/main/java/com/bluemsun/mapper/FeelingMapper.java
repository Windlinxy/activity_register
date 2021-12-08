package com.bluemsun.mapper;

import com.bluemsun.entity.Feeling;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FeelingMapper {

    int deleteByPrimaryKey(int id);

    int insert(Feeling record);

    Feeling selectByPrimaryKey(int id);

    List<Feeling> selectAllByUsername(String username);

    int updateByPrimaryKey(Feeling record);

}
