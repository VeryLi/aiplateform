package com.ai.schedule.bean.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 停止图片、视频分析任务请求
 */
@Data
public class StoppingAnalysisJobRequest {

    @NotNull(message = "待停止的任务ID列表为空")
    @JsonProperty("uuids")
    private List<String> uuids;

}
