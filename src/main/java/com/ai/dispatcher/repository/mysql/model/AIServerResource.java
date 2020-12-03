package com.ai.dispatcher.repository.mysql.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * AI服务器资源信息
 */
@Data
@Alias("AIServerResource")
public class AIServerResource {

    private int id;

    // AI服务器ID
    private int serverId;

    // GPU可用显存
    private int gpuAvailableMemory;

    // GPU可用卡数
    private int gpuAvailableSlots;

    // CPU可用核数
    private int cpuAvailableCores;

    // 可用内存
    private int availableMemory;

    // 可用磁盘总量
    private int availableDiskSpace;

    // AI服务器状态
    private int status;

    private long createTime;
    private long updateTime;
}
