package com.lincheng.study.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class StudyDubboProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyDubboProductApplication.class, args);
    }

}
