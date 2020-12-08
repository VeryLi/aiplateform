package com.ai.schedule.service.impl;

import com.ai.schedule.repository.mysql.dao.AlgorithmServiceResourceDao;
import com.ai.schedule.repository.mysql.dao.RepositoryLoadingInfoDao;
import com.ai.schedule.service.ISearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 检索功能服务类
 */
@Slf4j
@Service
public class SearchServiceImpl implements ISearchService {

    private final AlgorithmServiceResourceDao algorithmServiceResourceDao;
    private final RepositoryLoadingInfoDao repositoryLoadingInfoDao;

    public SearchServiceImpl(RepositoryLoadingInfoDao repositoryLoadingInfoDao,
                             AlgorithmServiceResourceDao algorithmServiceResourceDao) {
        this.repositoryLoadingInfoDao = repositoryLoadingInfoDao;
        this.algorithmServiceResourceDao = algorithmServiceResourceDao;
    }
}
