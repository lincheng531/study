package com.lincheng.study.rocketmqproduct.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author linCheng
 * @date 2021/5/25 15:35
 */
public interface Source {

    /**
     * @author: linCheng
     * @description: 我们通过 @Output 注解，声明了一个名字为 erbadagang-output 的 Output Binding。
     *               注意:这个名字要和我们配置文件中的 spring.cloud.stream.bindings 配置项对应上。
     * @date: 2021/5/26 11:54
     * @return
     */
    @Output("erbadagang-output")
    MessageChannel erbadagangOutput();


}
