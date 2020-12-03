package com.ai.dispatcher.repository.mysql.dao;

import com.ai.dispatcher.repository.mysql.mapper.RepositoryLoadingInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RepositoryLoadingInfoDao {

    private final RepositoryLoadingInfoMapper repositoryLoadingInfoMapper;

    public RepositoryLoadingInfoDao(RepositoryLoadingInfoMapper repositoryLoadingInfoMapper) {
        this.repositoryLoadingInfoMapper = repositoryLoadingInfoMapper;
    }
}
