package com.ai.schedule.bean.repo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreatingStaticRepositoryRequest {


    @NotEmpty(message = "库名称不能为空")
    @JsonProperty("repository_name")
    private String repositoryName;

    // 需要入库的厂商算子类型
    @NotEmpty(message = "需要入库的厂商算子类型为空")
    @JsonProperty("algorithm_type")
    private String algorithmType;

    // 1-人体、2-车辆、3-人脸、4-非机动车
    @NotEmpty(message = "存储对象类型为空")
    @JsonProperty("obj_type")
    private String objType;

}
