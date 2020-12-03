package com.ai.dispatcher.service.impl;

import com.ai.dispatcher.repository.mysql.dao.AIServerResourceDao;
import com.ai.dispatcher.repository.mysql.dao.ChannelAnalysisInfoDao;
import com.ai.dispatcher.repository.mysql.dao.RepositoryLoadingInfoDao;
import com.ai.dispatcher.service.IChannelAnalysisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 通道分析功能服务类
 */
@Slf4j
@Service
public class ChannelAnalysisServiceImpl implements IChannelAnalysisService {

    private final ChannelAnalysisInfoDao channelAnalysisInfoDao;
    private final AIServerResourceDao aiServerResourceDao;
    private final RepositoryLoadingInfoDao repositoryLoadingInfoDao;

    public ChannelAnalysisServiceImpl(ChannelAnalysisInfoDao channelAnalysisInfoDao,
                                      AIServerResourceDao aiServerResourceDao,
                                      RepositoryLoadingInfoDao repositoryLoadingInfoDao) {
        this.channelAnalysisInfoDao = channelAnalysisInfoDao;
        this.aiServerResourceDao = aiServerResourceDao;
        this.repositoryLoadingInfoDao = repositoryLoadingInfoDao;
    }
}
