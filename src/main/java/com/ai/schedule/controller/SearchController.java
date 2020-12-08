package com.ai.schedule.controller;

import com.ai.schedule.bean.search.SearchOnCaptureRepoRequest;
import com.ai.schedule.bean.search.SearchOnStaticRepoRequest;
import com.ai.schedule.bean.search.SearchResultResponse;
import com.ai.schedule.service.ISearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 该类主要负责处理有关搜索有关的请求
 */
@Slf4j
@RestController
@RequestMapping("/feature_query")
public class SearchController {

    private final ISearchService searchService;

    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }

    @CrossOrigin
    @RequestMapping(value = "/static_repository", method = RequestMethod.POST)
    public SearchResultResponse searchPictureOnStaticRepository(@Validated @RequestBody SearchOnStaticRepoRequest searchPictureRequest,
                                                                HttpServletRequest httpServletRequest) {
        return null;
    }

    @CrossOrigin
    @RequestMapping(value = "/capture_repository", method = RequestMethod.POST)
    public SearchResultResponse searchPictureOnCaptureRepository(@Validated @RequestBody SearchOnCaptureRepoRequest searchPictureRequest,
                                                                 HttpServletRequest httpServletRequest) {
        return null;
    }
}
