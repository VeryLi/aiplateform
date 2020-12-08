package com.ai.schedule.repository.mysql.mapper;

import com.ai.schedule.repository.mysql.model.AIServerResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AIServerResourceMapper {

    AIServerResource findById(int id);
    
}
