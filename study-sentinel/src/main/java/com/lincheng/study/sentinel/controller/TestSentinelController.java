package com.lincheng.study.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
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


    @RequestMapping("/hello1")
    public String hello1(){
        Entry entry = null;
        try {
            entry = SphU.entry("hello1");
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
        flowRule.setResource("hello1");
        //设置流控规则QBS
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源阈值
        // Set limit QPS to 20.
        flowRule.setCount(1) ;
        flowRules.add(flowRule) ;




        //流控
        FlowRule flowRule2 = new FlowRule();
        //设置受保护的资源
        flowRule2.setResource("hello2");
        //设置流控规则QBS
        flowRule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源阈值
        // Set limit QPS to 20.
        flowRule2.setCount(1) ;
        flowRules.add(flowRule2) ;

        FlowRuleManager.loadRules(flowRules);

    }


    /**
     * @SentinelResource 改善hello2接口中资源定义和被流控降级后的处理方法
     *          1.添加依赖：<artifactId>sentinel-annotation-aspectj</artifactId>
     *          2.配置bean-,SentinelResourceAspect
     *      value 定义资源
     *
     *      blockHandler设置流控降级后的处理方法(默认该方法必须声明在同一个类中)
     *          如果不想在同一个类中，使用blockHandlerClass但是方法必须是static
     *
     *      fallback当接口出现了 异常，就可以交给fallback指定的方法进行处理
     *          如果不想在同一个类中，使用fallbackClass但是方法必须是static
     *
     *      blockHandler如果和fallback同时使用了，则blockHandler 优先级更高
     *
     *      exceptionsToIgnore排除哪些异常不处理
     * @return
     */
    @SentinelResource(value = "hello2",fallback = "fallbackHandler",blockHandler = "blockHandler")
    @RequestMapping("/hello2")
    public String hello2(String id){
        Integer a = 1/0;
        return "hello2";
    }

    public String fallbackHandler(String id,Throwable ex){
        return "异常了！！！";
    }


    /**
     * 注意:
     * 1.定要public
     * 2.返回值一 定要和源方法保证一一致， 包含源方法的参数。
     * 3.可以在参数最后添加BlockException 可以区分是什么规则的处理方法
     * @param ex
     * @return
     */
    public String blockHandler(String id,BlockException ex) {
        ex.printStackTrace() ;
        return "流控! ! " ;
    }


}
