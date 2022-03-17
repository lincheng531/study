package com.lincheng.study.quartz.run;

import com.lincheng.study.common.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Classname AddNumWorker
 * @Description 产生随机数定时任务
 * @Date 2020/3/18 17:37
 * @Created by gangye
 */
@Component
public class AddNumWorker {


    public void work(){
        System.out.println(DateUtils.dateToString(new Date()));
    }

}
