package com.lincheng.study.rocketmqproduct;

import com.lincheng.study.rocketmqproduct.stream.Source;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Source.class)
public class StudyRocketmqProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyRocketmqProductApplication.class, args);
    }

}
