package com.bluemsun.service.impl;

import com.bluemsun.entity.Activity;
import com.bluemsun.entity.Feeling;
import com.bluemsun.mapper.FeelingMapper;
import com.bluemsun.service.FeelingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: activity_register
 * @description: 感悟服务接口实现类
 * @author: Windlinxy
 * @create: 2021-12-08 18:43
 **/
public class FeelingServiceImpl implements FeelingService {
    @Autowired
    private FeelingMapper mapper;

    @Override
    public int addFeeling(Feeling record) {
        int jud = 0;
        try {
            mapper.insert(record);
            jud = 1;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return jud;
    }

    @Override
    public List<Feeling> queryFeelingByUsername(String username) {
        List<Feeling> dataList;
        if (username == null){
            return null;
        }
        try{
            dataList = mapper.selectAllByUsername(username);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return dataList;
    }

    @Override
    public int deleteFeelingById(int id) {
        int jud = 0;
        try{
            jud = mapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return jud;
    }

    @Override
    public int changeFeeling(Feeling record) {
        int jud = 0;
        try{
            jud = mapper.updateByPrimaryKey(record);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return jud;
    }
}
