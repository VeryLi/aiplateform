package com.ai.dispatcher.service.impl;

import com.ai.dispatcher.repository.mysql.dao.SurveillanceInfoDao;
import com.ai.dispatcher.service.ISurveillanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
