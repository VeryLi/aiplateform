package com.ai.dispatcher.repository.redis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisStringDao {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisStringDao(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Boolean hasKey(String key) {
        if(StringUtils.isNotBlank(key)){
            return this.redisTemplate.hasKey(key);
        }
        return false;
    }

    public Boolean deleteByKey(String key) {
        try {
            return redisTemplate.delete(key);
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public Boolean deleteByKeys(String... keys) {
        try {
            redisTemplate.delete(Arrays.asList(keys));
            return true;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public void setExpire(String key, long time, TimeUnit timeUnit) {
        if(StringUtils.isNotBlank(key)){
            try {
                if(this.hasKey(key)){
                    redisTemplate.expire(key, time, timeUnit);
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    public String getByKey(String key) {
        String result = "";
        try {
            result = this.redisTemplate.opsForValue().get(key);
        } catch (Exception e){
            log.error(e.getMessage(), e);
        }
        return result;
    }

    public Boolean put(String key, String value){
        if(StringUtils.isBlank(key) || StringUtils.isBlank(value)){
            log.warn("key or value is empty.");
            return false;
        }
        try {
            this.redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
