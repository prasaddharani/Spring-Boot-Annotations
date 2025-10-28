package com.example.annotations.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class StudentSchedulingService {

    @Scheduled(cron = "*/10 * * * * *")
    public void cronExpression() {
        System.out.println("Running with cron expression : "+ LocalDateTime.now());
    }
}
