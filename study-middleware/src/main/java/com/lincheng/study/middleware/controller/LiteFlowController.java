package com.lincheng.study.middleware.controller;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: linCheng
 * @create: 2023-05-21 17:33
 **/
@RestController
@RequestMapping("/liteFlow")
public class LiteFlowController {

    @Resource
    private FlowExecutor flowExecutor;

    @GetMapping("/test")
    public void liteflow1() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain1", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    @GetMapping("/liteflow2")
    public void liteflow2() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain2", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    @GetMapping("/liteflow3")
    public void liteflow3() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain3", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    @GetMapping("/liteflow4")
    public void liteflow4() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain4", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


}
