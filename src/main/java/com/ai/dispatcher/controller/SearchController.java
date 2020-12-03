package com.ai.dispatcher.controller;

import com.ai.dispatcher.service.ISearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * 该类主要负责处理有关搜索有关的请求
 */
@Slf4j
@RestController("/search")
public class SearchController {

    private final ISearchService searchService;

    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }
}
