package com.ai.schedule.repository.mysql.dao;

import com.ai.schedule.repository.mysql.mapper.AIServerResourceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Slf4j
@Service
public class AIServerResourceDao {

    private final AIServerResourceMapper aiServerResourceMapper;

    public AIServerResourceDao(AIServerResourceMapper aiServerResourceMapper) {
        this.aiServerResourceMapper = aiServerResourceMapper;
    }

}
