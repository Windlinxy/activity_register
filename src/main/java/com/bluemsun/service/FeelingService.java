package com.bluemsun.service;

import com.bluemsun.entity.Activity;
import com.bluemsun.entity.Feeling;

import java.util.List;

/**
 * @program: activity_register
 * @description: 感悟服务接口
 * @author: Windlinxy
 * @create: 2021-12-08 18:43
 **/
public interface FeelingService {
    /**
     * 增加感悟记录
     *
     * @date 18:10 2021/12/8
     * @param record 填写感悟
     * @return int 返回成功与否（1成功、0失败）
     **/
    int addFeeling(Feeling record);

    /**
     * 查询感悟
     *
     * @date 18:11 2021/12/8
     * @param username 账号
     * @return java.util.List<com.bluemsun.entity.Activity> 数据
     **/
    List<Feeling> queryFeelingByUsername(String username);

    /**
     * 删除感悟
     *
     * @date 18:11 2021/12/8
     * @param id 感悟id
     * @return int id
     **/
    int deleteFeelingById(int id);

    /**
     * 修改感悟
     *
     * @date 18:11 2021/12/8
     * @param record 感悟
     * @return int 返回成功与否（1成功、0失败）、
     **/
    int changeFeeling(Feeling record);
}
