package com.ai.dispatcher.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockedThreadPool {

    private ThreadPoolExecutor pool;

    public BlockedThreadPool(String namePrefix, int core, int max, int queueMax) {
        if (core < 1) {
            core = 1;
        }
        if (max < core) {
            max = core;
        }
        if (queueMax < 1) {
            queueMax = 1;
        }
        this.pool = new ThreadPoolExecutor(
                core,
                max,
                10 * 1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(queueMax),
                new CustomThreadFactory(namePrefix),
                new CustomRejectedExecutionHandler());
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            this.pool.execute(runnable);
        }
    }

    public <T> Future<T> submit(Callable<T> callable) {
        if (callable != null) {
            return this.pool.submit(callable);
        }

        return null;
    }


    private static class CustomThreadFactory implements ThreadFactory {

        private String namePrefix;
        private AtomicInteger counter;

        CustomThreadFactory(String namePrefix) {
            if (StringUtils.isBlank(namePrefix)) {
                namePrefix = "Dispatcher-Default-";
            }
            this.namePrefix = namePrefix;
            this.counter = new AtomicInteger(1);
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = this.namePrefix + "-" + this.counter.getAndIncrement();
            t.setName(threadName);
            return t;
        }
    }

    @Slf4j
    private static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                executor.getQueue().put(r);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
