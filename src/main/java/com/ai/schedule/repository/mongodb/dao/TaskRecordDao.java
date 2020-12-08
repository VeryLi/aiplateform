package com.ai.schedule.repository.mongodb.dao;

import com.ai.schedule.repository.mongodb.model.TaskRecord;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TaskRecordDao {

    private final MongoTemplate mongoTemplate;

    public TaskRecordDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public TaskRecord findById(String taskId) {
        try {
            return this.mongoTemplate.findById(taskId, TaskRecord.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public List<TaskRecord> findList(int page, int size) {
        List<TaskRecord> records = new ArrayList<>();
        try {
            Query query = new Query();
            //排序
            Sort sort = Sort.by(Sort.Direction.DESC, "start_time");
            //分页
            Pageable pageable = PageRequest.of(page, size);
            query.with(pageable);
            query.with(sort);
            records = this.mongoTemplate.find(query, TaskRecord.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return records;
    }

    public boolean removeById(String taskId) {
        TaskRecord removed = new TaskRecord();
        removed.setId(taskId);
        try {
            DeleteResult result = this.mongoTemplate.remove(removed);
            long deletedCount = result.getDeletedCount();
            if (deletedCount > 1) {
                log.warn("removed more than one task record.");
            } else if (deletedCount < 1) {
                log.warn("removed nothing.");
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public boolean insert(TaskRecord tr) {
        try {
            this.mongoTemplate.insert(tr);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public boolean updateById(TaskRecord tr) {
        try {
            Query query = new Query(Criteria.where("id").is(tr.getId()));
            Update update = new Update();
            UpdateResult result = this.mongoTemplate.upsert(query, update, TaskRecord.class);
            long modifiedCount = result.getModifiedCount();
            if (modifiedCount > 1) {
                log.warn("modified more than one task record.");
            } else if (modifiedCount < 1) {
                log.warn("modified nothing.");
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
