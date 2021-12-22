package com.lincheng.study.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: linCheng
 * @create: 2021-12-22 22:33
 **/
@RestController
@RequestMapping("/sentinel")
public class TestSentinelController {


    @RequestMapping("/hello")
    public String hello(){
        Entry entry = null;
        try {
            entry = SphU.entry("hello");
            return "hello sentinel";
        } catch (BlockException e) {
            e.printStackTrace();
            return "被流控了";
        }catch (Exception ex){
            Tracer.traceEntry(ex,entry);
        }finally {
            if (entry != null){
                entry.exit();
            }
        }
        return null;
    }


    @PostConstruct
    private static void initFlowRules(){

        //流控规则
        List<FlowRule> flowRules = new ArrayList<>();

        //流控
        FlowRule flowRule = new FlowRule();
        //设置受保护的资源
        flowRule.setResource("hello");
        //设置流控规则QBS
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源阈值
        // Set limit QPS to 20.
        flowRule.setCount(1) ;
        flowRules.add(flowRule) ;

        FlowRuleManager.loadRules(flowRules);

    }

}
