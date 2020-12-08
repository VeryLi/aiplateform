package com.ai.schedule.bean.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchResultItem {

    // 每个目标的唯一ID
    @JsonProperty("unique_id")
    private String uniqueId;

    // 搜索目标与需要比对目标的相似度
    @JsonProperty("similarity")
    private float similarity;

}
