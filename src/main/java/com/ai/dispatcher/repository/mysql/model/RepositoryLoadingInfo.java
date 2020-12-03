package com.ai.dispatcher.repository.mysql.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 静态库/布控库/抓拍库等库加载信息
 */
@Data
@Alias("RepositoryLoadingInfo")
public class RepositoryLoadingInfo {

    private int id;

    // 库ID
    private int repositoryId;

    // 图片比对算法服务ID（表示这个库加载在这个图片比对算法服务中）
    private int loadingOnAlgorithmId;

    private int createTime;
    private int updateTime;
}
