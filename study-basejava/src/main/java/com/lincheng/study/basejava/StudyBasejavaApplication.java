package com.lincheng.study.basejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class StudyBasejavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyBasejavaApplication.class, args);
    }

}
