package com.ai.dispatcher.repository.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.io.Serializable;


/**
 * 以图搜图等异步任务的Task信息
 */
@Data
@Document(collection="task_records")
public class TaskRecord implements Serializable {

    // 唯一ID
    @Id
    private String id;

    @Field(name = "task_name", targetType = FieldType.STRING)
    private String taskName;

    @Field(name = "error_message", targetType = FieldType.STRING)
    private String errorMessage;

    @Field(name = "status", targetType = FieldType.INT32)
    private Integer status;

    @Field(name = "results", targetType = FieldType.STRING)
    private String results;

    @Field(name = "start_time", targetType = FieldType.INT64)
    private Long startTime;

    @Field(name = "end_time", targetType = FieldType.INT64)
    private Long endTime;

}
