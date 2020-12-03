package com.ai.dispatcher.repository.mysql.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 通道分析记录
 */
@Data
@Alias("ChannelAnalysisInfo")
public class ChannelAnalysisInfo {

    private int id;

    // 分析的通道ID
    private String channelId;

    // 该通道抓拍库的ID
    private int repositoryId;

    // 通道分析状态
    private int status;

    // 绑定的图片解析算法ID
    private int boundAlgoId;

    private long createTime;
    private long updateTime;

}
