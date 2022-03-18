package com.lincheng.study.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//数据库quartz-2.3.2.jar\org\quartz\impl\jdbcjobstore\tables_mysql.sql
@SpringBootApplication
public class StudyQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyQuartzApplication.class, args);
    }

}
