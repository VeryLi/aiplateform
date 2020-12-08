package com.ai.schedule.bean.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 查看分析任务执行结果请求
 */
@Data
public class AnalysisJobResultRequest {

    @JsonProperty("query_id")
    @NotEmpty(message = "任务ID为空")
    private String queryId;
}
