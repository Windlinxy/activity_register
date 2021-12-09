package com.bluemsun.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName tb_feeling
 */
@Data
public class Feeling implements Serializable {
    /**
     * 感悟id
     */
    private Integer feelingId;

    /**
     * 用户学号
     */
    private String feelingUser;

    /**
     * 学年
     */
    private Integer feelingYear;

    /**
     * 心情
     */
    private String feelingMood;

    /**
     * 自我评价
     */
    private String feelingSelfJud;

    /**
     * 感悟内容
     */
    private String feelingContent;

    public Feeling() {}
}