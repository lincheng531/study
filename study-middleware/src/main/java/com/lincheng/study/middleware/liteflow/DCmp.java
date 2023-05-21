package com.lincheng.study.middleware.liteflow;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("d")
public class DCmp extends NodeComponent {

    @Override
    public void process() {
        System.out.println("DCmp executed!");
    }
}
