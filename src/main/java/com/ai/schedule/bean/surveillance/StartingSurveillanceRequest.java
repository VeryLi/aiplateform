package com.ai.schedule.bean.surveillance;

import com.ai.schedule.bean.search.Threshold;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class StartingSurveillanceRequest {

    // 需要搜索的目标类型；1-人体、2-车辆、3-人脸、4-非机动车
    @NotEmpty(message = "查询对象类型")
    @JsonProperty("obj_type")
    private String objType;

    // 返回的特征相似度阈值
    @NotNull(message = "相似度阈值为空")
    @Threshold(message = "相似度阈值必须在[0, 1]区间内")
    @JsonProperty("threshold")
    private float threshold;

    @JsonProperty("repository_name")
    private String repositoryName;

    @NotEmpty(message = "布控库ID为空")
    @JsonProperty("repository_id")
    private String repositoryId;

    @NotNull(message = "需要布控的相机范围为空")
    @Size(min = 1, message = "需要布控的相机范围为空")
    @JsonProperty("surveillance_area")
    private List<String> surveillance_area;
}
