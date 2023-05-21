package com.lincheng.study.basejava.controller;

import com.lincheng.study.common.domain.redis.TestRedisVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-25 11:37
 **/
@RestController
@RequestMapping("/valid")
public class ValidController {


    @RequestMapping("/validTest")
    public void saveSeataOrderTest(@Valid @RequestBody TestRedisVO testRedisVO){

    }


}
