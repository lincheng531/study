package com.lincheng.study.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession//整合redis作为session存储
@SpringBootApplication
public class StudySessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySessionApplication.class, args);
    }

}
