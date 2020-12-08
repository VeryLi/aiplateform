package com.ai.schedule.bean.repo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DeletingStaticRepositoryRequest {

    @JsonProperty("repository_name")
    private String repositoryName;

    @NotEmpty(message = "待删除的静态库ID为空")
    @JsonProperty("repository_id")
    private String repositoryId;
}
