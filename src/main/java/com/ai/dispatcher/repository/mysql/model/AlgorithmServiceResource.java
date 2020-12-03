package com.ai.dispatcher.repository.mysql.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 算法服务资源信息
 */
@Data
@Alias("AlgorithmServiceResource")
public class AlgorithmServiceResource {
    private int id;

    // 算法服务名称
    private String algoServiceName;

    // 所在AI服务器ID
    private int serverId;

    // 使用算法镜像ID
    private int imageId;

    // 算法服务类型
    private int type;

    // 算法服务算力
    private int totalCapacityValue;

    // 算法服务理论可用算力
    private int availableCapacityValue;

    // 算法服务实际可用算力
    private int realCapacityValue;

    // 使用资源类型
    private int usingResourceType;

    // 算法服务状态
    private int status;

    private long createTime;
    private long updateTime;

}
