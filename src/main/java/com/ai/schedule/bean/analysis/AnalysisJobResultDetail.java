package com.ai.schedule.bean.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AnalysisJobResultDetail {

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("status")
    private int status;

}
