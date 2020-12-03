package com.ai.dispatcher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan("com.ai.dispatcher.repository.mysql.mapper")
@EnableWebMvc
@EnableAspectJAutoProxy
@SpringBootApplication
public class DispatcherLauncher {

    public static void main(String[] args) {
        SpringApplication.run(DispatcherLauncher.class);
    }
}
