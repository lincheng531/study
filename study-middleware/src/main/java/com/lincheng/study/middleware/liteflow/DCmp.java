package com.lincheng.study.middleware.liteflow;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("d")
public class DCmp extends NodeComponent {

    @Override
    public void process() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("DCmp executed!");
    }
}
