package com.ai.schedule.repository.mysql.dao;

import com.ai.schedule.repository.mysql.mapper.AnalysisJobMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnalysisJobDao {

    private final AnalysisJobMapper analysisJobMapper;

    public AnalysisJobDao(AnalysisJobMapper analysisJobMapper) {
        this.analysisJobMapper = analysisJobMapper;
    }
}

