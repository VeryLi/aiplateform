package com.ai.schedule.repository.mysql.dao;

import com.ai.schedule.repository.mongodb.dao.TaskRecordDao;
import com.ai.schedule.repository.mysql.mapper.RepositoryLoadingInfoMapper;
import com.ai.schedule.repository.redis.RedisStringDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class RepositoryLoadingInfoDao {

    private final TaskRecordDao taskRecordDao;
    private final RedisStringDao redisStringDao;
    private final RepositoryLoadingInfoMapper repositoryLoadingInfoMapper;

    public RepositoryLoadingInfoDao(RepositoryLoadingInfoMapper repositoryLoadingInfoMapper,
                                    TaskRecordDao taskRecordDao,
                                    RedisStringDao redisStringDao) {
        this.repositoryLoadingInfoMapper = repositoryLoadingInfoMapper;
        this.taskRecordDao = taskRecordDao;
        this.redisStringDao = redisStringDao;
    }
}
