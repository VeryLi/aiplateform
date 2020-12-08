package com.ai.schedule.bean.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AnalysisJobInputSources {

    // 经度
    @NotEmpty(message = "经度为空")
    @JsonProperty("longitude")
    private String longitude;

    // 纬度
    @NotEmpty(message = "纬度为空")
    @JsonProperty("latitude")
    private String latitude;

    // 媒体流地址，rtsp、http等
    @NotEmpty(message = "媒体流地址，rtsp、http等为空")
    @JsonProperty("uri")
    private String uri;

    // 任务区分唯一编号
    @NotEmpty(message = "任务唯一编号为空")
    @JsonProperty("uuid")
    private String uuid;

    // 流类型 1-实时视频流rtsp、2-离线视频包、3-实时图片流、4-离线图片文件包
    @NotEmpty(message = "流类型为空")
    @JsonProperty("stream_type")
    private int streamType;
}
