package com.ai.dispatcher.controller;

import com.ai.dispatcher.service.ISurveillanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * 该类主要负责接收布控有关的请求
 */
@Slf4j
@RestController("/surveillance")
public class SurveillanceController {


    private final ISurveillanceService surveillanceService;

    public SurveillanceController(ISurveillanceService surveillanceService) {
        this.surveillanceService = surveillanceService;
    }
}
