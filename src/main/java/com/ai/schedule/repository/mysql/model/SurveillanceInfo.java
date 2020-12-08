package com.ai.schedule.repository.mysql.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 记录布控信息
 */
@Data
@Alias("SurveillanceInfo")
public class SurveillanceInfo {

    private int id;

    // 布控的通道ID
    private String channelId;

    // 使用的布控库ID
    private int repositoryId;

    // 布控分析状态
    private int status;

    // 布控规则
    private String surveillanceRule;

    private long createTime;
    private long updateTime;

}
