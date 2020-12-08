package com.ai.schedule.bean.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SearchOnStaticRepoRequest {

    // 需要查找的静态库ID；
    @NotEmpty(message = "库ID为空")
    @JsonProperty("repository_id")
    private String repositoryId;

    // 返回的特征相似度阈值
    @NotNull(message = "相似度阈值为空")
    @Threshold(message = "相似度阈值必须在(0, 1]区间内")
    @JsonProperty("threshold")
    private float threshold;

    // 需要返回的特征数量，最大值1000；
    @Max(value = 1000, message = "返回特征值数量最大为1000")
    @Min(value = 1, message = "返回特征值数据量最小为1")
    @JsonProperty("count")
    private int count;

    // 图像存储在oss中的url
    @NotEmpty(message = "图片URL不能为空")
    @JsonProperty("url")
    private String url;
}
