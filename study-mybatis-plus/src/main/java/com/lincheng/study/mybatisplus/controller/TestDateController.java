package com.lincheng.study.mybatisplus.controller;


import com.alibaba.fastjson.JSON;
import com.lincheng.study.common.utils.DateUtils;
import com.lincheng.study.mybatisplus.entity.TestDate;
import com.lincheng.study.mybatisplus.service.ITestDateService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * <p>
 * 测试时间 前端控制器
 * </p>
 *
 * @author linCheng
 * @since 2021-12-08
 */
@RestController
@RequestMapping("/mybatisplus/testDate")
public class TestDateController {


    @Resource
    private ITestDateService testDateService;

    @RequestMapping("/test")
    public Object test(){
        TestDate testDate = testDateService.getById(1);
        return testDate;
    }


    @RequestMapping("/get")
    public Object get(@RequestBody TestDate testDate){
        System.out.println(JSON.toJSONString(testDate));
        testDateService.save(testDate);
        return testDate;
    }


    public static void main(String[] args) {
        String reqBody2 = DateUtils.timestampToString(new Timestamp(1638937235000L));
        String reqBody21 = DateUtils.timestampToString(new Timestamp(1638937237000L));
        System.out.println(reqBody2);
        System.out.println(reqBody21);

    }
}

