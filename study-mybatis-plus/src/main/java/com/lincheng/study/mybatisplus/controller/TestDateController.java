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
import java.time.LocalDate;
import java.util.Date;

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
        //String reqBody2 = DateUtils.timestampToString(new Timestamp(1638937235000L));
        //String reqBody21 = DateUtils.timestampToString(new Timestamp(1638937237000L));
        //System.out.println(reqBody2);
        //System.out.println(reqBody21);

        Timestamp timestamp = DateUtils.stringToTimestamp("2021-01-07", DateUtils.YYYYMMDD);
        System.out.println(timestamp);

        LocalDate localDate = DateUtils.stringToLocalDate("2021-01-07", DateUtils.YYYYMMDD);
        long time = DateUtils.localDateToTimestamp(localDate).getTime();
        long time1 = DateUtils.stringToTimestamp("2021-01-07 15:20:16", DateUtils.YYYYMMDDHHMMSS).getTime();
        System.out.println(time);
        System.out.println(time1);


        String time2 = DateUtils.timestampToString(new Timestamp(1609948800000L));
        System.out.println(time2);

    }
}

