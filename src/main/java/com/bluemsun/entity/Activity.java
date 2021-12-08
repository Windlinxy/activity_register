package com.bluemsun.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName tb_activity
 */
@Data
public class Activity implements Serializable {
    /**
     * 活动id
     */
    private Integer activityId;

    /**
     * 谁填的活动
     */
    private String activityUser;

    /**
     * 活动日期
     */
    private String activityDate;

    /**
     * 活动名
     */
    private String activityName;

    /**
     * 活动时长
     */
    private String activityTime;

    /**
     * 参与方式
     */
    private String activityTakeWay;

    /**
     * 主办方
     */
    private String activityMaster;

    /**
     * 证明人
     */
    private String activityReferences;

    /**
     * 是否志愿
     */
    private int activityVoluntary;

    public Activity() {}

    public Activity(String activityUser, String activityDate, String activityName, String activityTime, String activityTakeWay, String activityMaster, String activityReferences, int activityVoluntary) {
        this.activityUser = activityUser;
        this.activityDate = activityDate;
        this.activityName = activityName;
        this.activityTime = activityTime;
        this.activityTakeWay = activityTakeWay;
        this.activityMaster = activityMaster;
        this.activityReferences = activityReferences;
        this.activityVoluntary = activityVoluntary;
    }

    public Activity(Integer activityId, String activityUser, String activityDate, String activityName, String activityTime, String activityTakeWay, String activityMaster, String activityReferences, int activityVoluntary) {
        this.activityId = activityId;
        this.activityUser = activityUser;
        this.activityDate = activityDate;
        this.activityName = activityName;
        this.activityTime = activityTime;
        this.activityTakeWay = activityTakeWay;
        this.activityMaster = activityMaster;
        this.activityReferences = activityReferences;
        this.activityVoluntary = activityVoluntary;
    }
}