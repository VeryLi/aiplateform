package com.ai.dispatcher.service.impl;

import com.ai.dispatcher.repository.mysql.dao.AlgorithmServiceResourceDao;
import com.ai.dispatcher.repository.mysql.dao.RepositoryLoadingInfoDao;
import com.ai.dispatcher.service.ISearchService;
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
