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
    /*
    * 普通组件
    */
    public void liteflow1() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain1", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /*
     * 选择组件
     */
    @GetMapping("/liteflow2")
    public void liteflow2() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain2", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /*
     * 选择组件
     */
    @GetMapping("/liteflow3")
    public void liteflow3() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain3", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /*
     * 条件组件
     */
    @GetMapping("/liteflow4")
    public void liteflow4() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain4", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    /*
     * 次数循环组件
     */
    @GetMapping("/liteflow5")
    public void liteflow5() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain5", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /*
     * 条件循环组件
     */
    @GetMapping("/liteflow6")
    public void liteflow6() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain6", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    /*
     * 迭代循环组件
     */
    @GetMapping("/liteflow7")
    public void liteflow7() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain7", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    /*
     * 退出循环组件
     */
    @GetMapping("/liteflow8")
    public void liteflow8() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain8", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    /*==========================================================EL规则的写法========================================================*/





    /*
     * 串行编排
     */
    @GetMapping("/liteflow9")
    public void liteflow9() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain9", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }



    /*
     * 并行编排
     */
    @GetMapping("/liteflow10")
    public void liteflow10() {
        try {
            LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain10", "arg");
            System.out.println(liteflowResponse);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }






















}
