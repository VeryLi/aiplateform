package com.ai.schedule.controller;

import com.ai.schedule.bean.analysis.AnalysisJobResultRequest;
import com.ai.schedule.bean.analysis.AnalysisJobResultResponse;
import com.ai.schedule.bean.analysis.StartingAnalysisJobRequest;
import com.ai.schedule.bean.analysis.StartingAnalysisJobResponse;
import com.ai.schedule.service.IAnalysisJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 该类主要负责处理和分析有关的请求
 */
@Slf4j
@RestController
public class AnalysisJobController {

    private final IAnalysisJobService analysisJobService;

    public AnalysisJobController(IAnalysisJobService analysisJobService) {
        this.analysisJobService = analysisJobService;
    }


    /**
     * 开启图片、视频分析任务
     *
     * @param jobRequest     开启分析任务的请求
     * @param servletRequest httpServlet请求
     * @return 开启分析任务的结果响应
     */
    @CrossOrigin
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public StartingAnalysisJobResponse startUpAnalysisJob(@Validated @RequestBody StartingAnalysisJobRequest jobRequest,
                                                          HttpServletRequest servletRequest) {
        return null;
    }

    /**
     * 停止图片、视频分析任务
     *
     * @param jobRequest     停止分析任务的请求
     * @param servletRequest httpServlet请求
     * @return 停止分析任务的结果响应
     */
    @CrossOrigin
    @RequestMapping(value = "/task", method = RequestMethod.DELETE)
    public StartingAnalysisJobResponse stopAnalysisJob(@Validated @RequestBody StartingAnalysisJobRequest jobRequest,
                                                       HttpServletRequest servletRequest) {

        return null;
    }

    /**
     * 任务执行结果查询
     *
     * @param jobResultRequest 查询分析任务执行结果请求
     * @param servletRequest   httpServlet请求
     * @return 查询分析任务执行结果
     */
    @CrossOrigin
    @RequestMapping(value = "/results", method = RequestMethod.POST)
    public AnalysisJobResultResponse queryAnalysisJobExecutingResult(@Validated @RequestBody AnalysisJobResultRequest jobResultRequest,
                                                                     HttpServletRequest servletRequest) {
        return null;
    }
}
