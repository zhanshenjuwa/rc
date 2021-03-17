package com.zhishi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@PropertySource(value = "classpath:message.properties",encoding = "utf-8")
public class AppfrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppfrontApplication.class, args);
    }
}
