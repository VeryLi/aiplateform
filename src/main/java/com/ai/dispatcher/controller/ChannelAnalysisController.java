package com.ai.dispatcher.controller;

import com.ai.dispatcher.service.IChannelAnalysisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 该类主要负责处理和通道分析有关的请求
 */
@Slf4j
@RestController("/analysis")
public class ChannelAnalysisController {

    private final IChannelAnalysisService channelAnalysisService;

    public ChannelAnalysisController(IChannelAnalysisService channelAnalysisService) {
        this.channelAnalysisService = channelAnalysisService;
    }


}
