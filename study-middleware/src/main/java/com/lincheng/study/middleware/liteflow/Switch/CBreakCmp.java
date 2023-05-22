package com.lincheng.study.middleware.liteflow.Switch;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeBreakComponent;
import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@LiteflowComponent("cbreak")
public class CBreakCmp extends NodeBreakComponent {
    @Override
    public boolean processBreak() throws Exception {
        //这里根据业务去返回break的结果
        return false;
    }
}
