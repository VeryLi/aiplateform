package com.ai.schedule.commons;

import com.ai.schedule.config.SchedulingConfig;
import com.ai.schedule.utils.BlockedThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

@Slf4j
@Component
public class ThreadPoolManager {

    private final SchedulingConfig schedulingConfig;
    private final ConcurrentHashMap<String, BlockedThreadPool> threadPools;

    public ThreadPoolManager(SchedulingConfig schedulingConfig) {
        this.schedulingConfig = schedulingConfig;
        this.threadPools = new ConcurrentHashMap<>();
    }


    @PostConstruct
    private void init() {
        if (this.schedulingConfig.getThreadPools() != null) {
            for (SchedulingConfig.ThreadPoolConfig threadPoolConfig : this.schedulingConfig.getThreadPools()) {
                if (!this.threadPools.containsKey(threadPoolConfig.getName())) {
                    BlockedThreadPool threadPool = new BlockedThreadPool(
                            threadPoolConfig.getPrefixName(),
                            threadPoolConfig.getCore(),
                            threadPoolConfig.getMax(),
                            threadPoolConfig.getQueue()
                    );
                    this.threadPools.put(threadPoolConfig.getName(), threadPool);
                }
            }
        }
    }

    public void execute(String poolName, Runnable runnable) {
        if (StringUtils.isBlank(poolName)) {
            log.error("thread pool name is empty");
            return;
        }
        if (!this.threadPools.containsKey(poolName)) {
            log.error("thread pool name: {} doesn't exist", poolName);
            return;
        }
        this.threadPools.get(poolName).execute(runnable);
    }

    public <T> Future<T> submit(String poolName, Callable<T> callable) {
        if (StringUtils.isBlank(poolName)) {
            log.error("thread pool name is empty");
            return null;
        }
        if (!this.threadPools.containsKey(poolName)) {
            log.error("thread pool name: {} doesn't exist", poolName);
            return null;
        }
        return this.threadPools.get(poolName).submit(callable);
    }
}
