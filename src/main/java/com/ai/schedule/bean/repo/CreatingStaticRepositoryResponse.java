package com.ai.schedule.bean.repo;

import com.ai.schedule.bean.CommonResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreatingStaticRepositoryResponse extends CommonResponse {

    @JsonProperty("repository_id")
    private String repositoryId;

}
