package com.ai.schedule.bean.search;

import com.ai.schedule.bean.CommonResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchResultResponse extends CommonResponse {

    // 各目标比对结果具体内容
    @JsonProperty("results")
    private List<SearchResultItem> results;

}
