package com.ai.dispatcher.repository.mysql.dao;

import com.ai.dispatcher.repository.mysql.mapper.ChannelAnalysisInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChannelAnalysisInfoDao {

    private final ChannelAnalysisInfoMapper channelAnalysisInfoMapper;

    public ChannelAnalysisInfoDao(ChannelAnalysisInfoMapper channelAnalysisInfoMapper) {
        this.channelAnalysisInfoMapper = channelAnalysisInfoMapper;
    }
}

