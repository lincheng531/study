package com.lincheng.study.middleware.liteflow.Switch;

import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;
import org.springframework.stereotype.Component;

@Component("aS")
public class ASwitchCmp extends NodeSwitchComponent {

    @Override
    public String  processSwitch() {
        //先执行a,再执行c
        System.out.println("ASwitchCmp executed!");
        return "c";
    }
}
