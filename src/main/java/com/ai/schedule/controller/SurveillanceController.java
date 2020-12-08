package com.ai.schedule.controller;

import com.ai.schedule.bean.CommonResponse;
import com.ai.schedule.bean.surveillance.StartingSurveillanceRequest;
import com.ai.schedule.service.ISurveillanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 该类主要负责接收布控有关的请求
 */
@Slf4j
@RestController
@RequestMapping("/surveillance")
public class SurveillanceController {


    private final ISurveillanceService surveillanceService;

    public SurveillanceController(ISurveillanceService surveillanceService) {
        this.surveillanceService = surveillanceService;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public CommonResponse startUpSurveillance(@Validated @RequestBody StartingSurveillanceRequest startingSurveillanceRequest,
                                              HttpServletRequest httpServletRequest) {
        return null;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE)
    public CommonResponse stopSurveillance(@Validated @RequestBody StartingSurveillanceRequest startingSurveillanceRequest,
                                           HttpServletRequest httpServletRequest) {
        return null;
    }
}
