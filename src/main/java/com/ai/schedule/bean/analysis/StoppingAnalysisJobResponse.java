package com.ai.schedule.bean.analysis;

import com.ai.schedule.bean.CommonResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 停止图片、视频分析任务响应
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StoppingAnalysisJobResponse extends CommonResponse {

    @JsonProperty("query_id")
    private String queryId;

}
