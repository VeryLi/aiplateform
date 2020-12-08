package com.ai.schedule.service.impl;

import com.ai.schedule.repository.mysql.dao.SurveillanceInfoDao;
import com.ai.schedule.service.ISurveillanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 布控功能服务类
 */
@Slf4j
@Service
public class SurveillanceServiceImpl implements ISurveillanceService {

    private final SurveillanceInfoDao surveillanceInfoDao;

    public SurveillanceServiceImpl(SurveillanceInfoDao surveillanceInfoDao) {
        this.surveillanceInfoDao = surveillanceInfoDao;
    }
}
