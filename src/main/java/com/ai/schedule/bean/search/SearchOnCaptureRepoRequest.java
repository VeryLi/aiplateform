package com.ai.schedule.bean.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class SearchOnCaptureRepoRequest {

    // 需要搜索的目标类型；1-人体、2-车辆、3-人脸、4-非机动车
    @NotEmpty(message = "查询对象类型")
    @JsonProperty("obj_type")
    private String objType;

    // 返回的特征相似度阈值
    @NotNull(message = "相似度阈值为空")
    @Threshold(message = "相似度阈值必须在[0, 1]区间内")
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

    @Timestamp(message = "开始时间为空或者时间格式非'yyyy-MM-dd HH:mm:ss'")
    @JsonProperty("start_time")
    private String startTime;

    @Timestamp(message = "截止时间为空或者时间格式非'yyyy-MM-dd HH:mm:ss'")
    @JsonProperty("end_time")
    private String endTime;

    // 需要搜索的范围，相机ID集合
    @NotNull(message = "需要搜索的范围为空")
    @Size(min = 1, message = "需要搜索的范围为空")
    @JsonProperty("search_area")
    private List<String> searchArea;

}
