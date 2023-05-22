package com.lincheng.study.middleware.liteflow;

import cn.hutool.core.collection.ListUtil;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeIteratorComponent;

import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: linCheng
 * @create: 2023-05-22 11:18
 **/
@LiteflowComponent("x")
public class XCmp extends NodeIteratorComponent {
    @Override
    public Iterator<?> processIterator() throws Exception {
        List<String> list = ListUtil.toList("jack", "mary", "tom");
        return list.iterator();
    }
}

