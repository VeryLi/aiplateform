package com.ai.schedule.bean.analysis;

import com.ai.schedule.bean.analysis.AnalysisJobInputSources;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 图片、视频分析任务请求Bean
 */
@Data
public class StartingAnalysisJobRequest {

    // 算法服务镜像对应的唯一ID
    @NotEmpty(message = "算法服务镜像ID为空")
    @JsonProperty("image_id")
    private String imageId;

    // 是否输出图像信息；“0”-不输出，“1”-输出
    @JsonProperty("output_picture")
    private String outputPicture;

    // 是否输出视频片段信息；“0”-不输出，“1”-输出
    @JsonProperty("output_video")
    private String outputVideo;

    // 是否输出特征信息；“0”-不输出，“1”-输出
    @NotEmpty(message = "输出特征信息标志位为空")
    @JsonProperty("output_feature")
    private String outputFeature;

    // 是否输出属性信息；“0”-不输出，“1”-输出
    @NotEmpty(message = "输出属性信息标志位为空")
    @JsonProperty("output_attribute")
    private String outputAttribute;

    // 输入流详细信息
    @NotNull(message = "输入流详细信息为空")
    @JsonProperty("input_sources")
    private List<AnalysisJobInputSources> inputSources;

}
