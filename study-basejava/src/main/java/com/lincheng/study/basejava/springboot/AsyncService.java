package com.lincheng.study.basejava.springboot;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-07-14 10:57
 **/
@Service
public class AsyncService {

    @Async
    public String async() throws InterruptedException {

        System.out.println("999999");
        Thread.sleep(5000);
        return "2333333";
    }

}
