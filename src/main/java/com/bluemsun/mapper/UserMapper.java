package com.bluemsun.mapper;

import com.bluemsun.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Windlinxy
 * @Entity generator.domain.TbUser
 */
@Mapper
public interface UserMapper {

    int insert(User record);

    User selectByPrimaryKey(Long id);

    int updatePassword(User user);

    User selectOne(User user);

}
