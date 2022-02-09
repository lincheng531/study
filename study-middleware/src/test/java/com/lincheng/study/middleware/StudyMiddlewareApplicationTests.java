package com.lincheng.study.middleware;

import com.lincheng.study.middleware.service.IEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyMiddlewareApplication.class)
public class StudyMiddlewareApplicationTests {

    @Resource
    private IEmailService emailService;



    @Test
    public void contextLoads() {
        boolean flag= emailService.sendAttachmentMail(Arrays.asList("924093347@qq.com","654014090@qq.com"), "测试邮箱-subject", "测试邮箱",null);
        System.out.println(flag);
    }



}
