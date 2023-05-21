package com.lincheng.study.basejava.config;

import com.lincheng.study.basejava.springboot.SpringBootServiceTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-07-12 17:24
 **/
@Configuration
public class Config {

    @Bean
    public SpringBootServiceTest getSpringBootServiceTest(){
        return new SpringBootServiceTest();
    }
}
