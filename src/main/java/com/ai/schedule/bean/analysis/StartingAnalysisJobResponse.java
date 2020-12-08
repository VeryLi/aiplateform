package com.ai.schedule.bean.analysis;

import com.ai.schedule.bean.CommonResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图片、视频分析任务响应Bean
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StartingAnalysisJobResponse extends CommonResponse {

    @JsonProperty("query_id")
    private String queryId;

}
