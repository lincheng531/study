package com.lincheng.study.quartz.run;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Classname ProStatisticsWorker
 * @Description 统计数据定时任务,并将统计结果添加到数据库中
 * @Date 2020/3/18 17:43
 * @Created by gangye
 */
@Component
public class ProStatisticsWorker {


    public void work(){
        System.out.println(new Date());
    }
}
