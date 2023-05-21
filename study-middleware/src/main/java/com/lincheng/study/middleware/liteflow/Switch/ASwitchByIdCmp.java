package com.lincheng.study.middleware.liteflow.Switch;

import com.yomahub.liteflow.core.NodeSwitchComponent;
import org.springframework.stereotype.Component;

@Component("aSById")
public class ASwitchByIdCmp extends NodeSwitchComponent {

    @Override
    public String processSwitch() throws Exception {
        System.out.println("Acomp executed!");
        return "w1";
    }
}
