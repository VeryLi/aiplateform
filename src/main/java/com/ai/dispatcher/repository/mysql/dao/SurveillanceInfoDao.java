package com.ai.dispatcher.repository.mysql.dao;

import com.ai.dispatcher.repository.mysql.mapper.SurveillanceInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SurveillanceInfoDao {

    private final SurveillanceInfoMapper surveillanceInfoMapper;

    public SurveillanceInfoDao(SurveillanceInfoMapper surveillanceInfoMapper) {
        this.surveillanceInfoMapper = surveillanceInfoMapper;
    }
}
