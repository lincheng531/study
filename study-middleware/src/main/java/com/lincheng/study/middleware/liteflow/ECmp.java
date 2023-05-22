package com.lincheng.study.middleware.liteflow;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("e")
public class ECmp extends NodeComponent {

    @Override
    public void process() throws InterruptedException {
        System.out.println("ECmp executed!");
    }
}
