package com.ai.schedule.repository.mysql.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 通道分析记录
 */
@Data
@Alias("AnalysisJob")
public class AnalysisJob {

    private int id;

    private String channelId;

    private int repositoryId;

    private int status;

    private int boundAlgoId;

    private long createTime;
    private long updateTime;

}
