package com.ai.dispatcher.repository.mysql.dao;

import com.ai.dispatcher.repository.mysql.mapper.AlgorithmServiceResourceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class AlgorithmServiceResourceDao {

    private final AlgorithmServiceResourceMapper algorithmServiceResourceMapper;

    public AlgorithmServiceResourceDao(AlgorithmServiceResourceMapper algorithmServiceResourceMapper) {
        this.algorithmServiceResourceMapper = algorithmServiceResourceMapper;
    }
}
