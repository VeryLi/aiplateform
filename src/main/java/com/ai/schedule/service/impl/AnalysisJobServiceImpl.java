package com.ai.schedule.service.impl;

import com.ai.schedule.repository.mysql.dao.AIServerResourceDao;
import com.ai.schedule.repository.mysql.dao.AnalysisJobDao;
import com.ai.schedule.repository.mysql.dao.RepositoryLoadingInfoDao;
import com.ai.schedule.service.IAnalysisJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 通道分析功能服务类
 */
@Slf4j
@Service
public class AnalysisJobServiceImpl implements IAnalysisJobService {

    private final AnalysisJobDao analysisJobDao;
    private final AIServerResourceDao aiServerResourceDao;
    private final RepositoryLoadingInfoDao repositoryLoadingInfoDao;

    public AnalysisJobServiceImpl(AnalysisJobDao analysisJobDao,
                                  AIServerResourceDao aiServerResourceDao,
                                  RepositoryLoadingInfoDao repositoryLoadingInfoDao) {
        this.analysisJobDao = analysisJobDao;
        this.aiServerResourceDao = aiServerResourceDao;
        this.repositoryLoadingInfoDao = repositoryLoadingInfoDao;
    }
}
