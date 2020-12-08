package com.ai.schedule.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "scheduling")
public class SchedulingConfig {

    private List<ThreadPoolConfig> threadPools;

    @Data
    @Component
    @ConfigurationProperties(prefix = "scheduling.thread-pools")
    public static class ThreadPoolConfig {
        private String name;
        private String prefixName;
        private int core;
        private int max;
        private int queue;
    }
}
