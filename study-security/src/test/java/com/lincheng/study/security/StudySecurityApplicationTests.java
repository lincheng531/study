package com.lincheng.study.security;

import com.lincheng.study.common.utils.ThreadUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class StudySecurityApplicationTests {

    @Test
    public void test1() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);

        boolean matches = bCryptPasswordEncoder.matches("123456", encode);
        System.out.println(matches);

    }

    @Test
    public void test2() {
        ThreadUtils.runInNewThreadByExecutors(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程run");
        });
        System.out.println("main run");
    }
}
