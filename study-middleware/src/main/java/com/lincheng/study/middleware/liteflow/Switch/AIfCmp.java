package com.lincheng.study.middleware.liteflow.Switch;

import com.yomahub.liteflow.core.NodeIfComponent;
import org.springframework.stereotype.Component;

@Component("aIf")
public class AIfCmp extends NodeIfComponent {

    @Override
    public boolean processIf() {
        //先执行a,再执行c
        System.out.println("AIfCmp executed!");
        return true;
    }
}
