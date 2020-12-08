package com.ai.schedule.bean.analysis;

import com.ai.schedule.bean.CommonResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 查看分析任务执行结果响应
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AnalysisJobResultResponse extends CommonResponse {

    @JsonProperty("results")
    private List<AnalysisJobResultDetail> results;

}
