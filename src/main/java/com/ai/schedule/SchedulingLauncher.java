package com.ai.schedule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan("com.ai.schedule.repository.mysql.mapper")
@EnableWebMvc
@EnableAspectJAutoProxy
@SpringBootApplication
public class SchedulingLauncher {

    public static void main(String[] args) {
        SpringApplication.run(SchedulingLauncher.class);
    }
}
