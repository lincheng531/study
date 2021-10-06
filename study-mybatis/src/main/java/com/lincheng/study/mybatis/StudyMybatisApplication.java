package com.lincheng.study.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lincheng.study.mybatis.dao")
public class StudyMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyMybatisApplication.class, args);
    }

}
