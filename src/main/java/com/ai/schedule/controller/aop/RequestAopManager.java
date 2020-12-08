package com.ai.schedule.controller.aop;

import com.ai.schedule.commons.Constants;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Slf4j
@Aspect
@Component
public class RequestAopManager {

    @Pointcut("execution(public * com.ai.schedule.controller.*Controller.*(..)))")
    public void BrokerAspect() {
    }

    @Around("BrokerAspect()")
    public Object traceRequest(ProceedingJoinPoint pjp) throws Throwable {
        String traceId = UUID.randomUUID().toString().replace("-", "");
        MDC.put(Constants.TraceId, traceId);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes != null){
            HttpServletRequest request = attributes.getRequest();
            log.info("starting [{}] {}", request.getMethod(), request.getRequestURI());
        }
        long startTime = System.currentTimeMillis();
        Object ret = pjp.proceed();
        long endTime = System.currentTimeMillis();
        log.info("completed request. it cost {} ms", (endTime - startTime));
        return ret;
    }
}
