package com.bluemsun.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Activity implements Serializable {
    /**
     * id
     */
    private Integer activityId;

    /**
     * 活动用户id
     */
    private Integer activityUser;

    /**
     * 活动日期
     */
    private Date activityDate;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动时长
     */
    private Date activityTime;

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
    private Byte activityVoluntary;

    public Activity() {
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", activityUserId=" + activityUser +
                ", activityDate=" + activityDate +
                ", activityName='" + activityName + '\'' +
                ", activityTime=" + activityTime +
                ", activityTakeWay='" + activityTakeWay + '\'' +
                ", activityMaster='" + activityMaster + '\'' +
                ", activityReferences='" + activityReferences + '\'' +
                ", activityVoluntary=" + activityVoluntary +
                '}';
    }
}