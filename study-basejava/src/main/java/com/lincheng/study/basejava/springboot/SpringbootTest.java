package com.lincheng.study.basejava.springboot;

import com.lincheng.study.basejava.vo.Proson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-07-12 16:07
 **/
@RestController
@PropertySource(value = {"classpath:person.properties"})
@RequestMapping("/SpringbootTest")
public class SpringbootTest {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private AsyncService asyncService;


    @Value("${person.dog.name}")
    private String dogName;

    @Value("#{1+2}")
    private String sum;

    @Value("true")
    private Boolean falg;

    @Resource
    private Proson proson;

    @RequestMapping("/test1")
    public Proson test1() {
        return proson;
    }

    @RequestMapping("/test2")
    public String test2() {
        System.out.println(dogName);
        System.out.println(falg);
        System.out.println(sum);
        return dogName;
    }


    @RequestMapping("/test3")
    public boolean test3() {
        return applicationContext.containsBean("getSpringBootServiceTest");
    }


    @RequestMapping("/test4")
    public String test4() throws InterruptedException {
        asyncService.async();
        return "success";
    }


}
