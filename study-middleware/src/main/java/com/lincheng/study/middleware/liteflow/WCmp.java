package com.lincheng.study.middleware.liteflow;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeWhileComponent;

/**
 * @description:
 * @author: linCheng
 * @create: 2023-05-22 11:13
 **/
@LiteflowComponent("w")
public class WCmp extends NodeWhileComponent {
    @Override
    public boolean processWhile() throws Exception {
        //这里根据业务去返回while的结果
        return false;
    }
}

