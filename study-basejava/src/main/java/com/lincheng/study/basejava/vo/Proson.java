package com.lincheng.study.basejava.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * @description:
 *      加上配置
 *       <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-configuration-processor</artifactId>
 *             <optional>true</optional>
 *        </dependency>
 * @author: linCheng
 * @create: 2022-07-12 16:00
 **/
@Component
@ConfigurationProperties(prefix = "person")
@PropertySource(value = {"classpath:person.properties"})
//jsr303数据校验
//@Validated
@Data
public class Proson {

    //@Email
    private String name;

    private List<String> lists;

    private Map<Object,Object> maps;

    private Dog dog;

}
