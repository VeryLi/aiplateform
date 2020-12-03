package com.ai.dispatcher.repository.mysql.mapper;

import com.ai.dispatcher.repository.mysql.model.AIServerResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AIServerResourceMapper {

    AIServerResource findById(int id);
    
}
