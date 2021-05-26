package com.lincheng.study.rocketmqconsumer;

import com.lincheng.study.rocketmqconsumer.stream.Source;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Source.class)
public class StudyRocketmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyRocketmqConsumerApplication.class, args);
    }

}
