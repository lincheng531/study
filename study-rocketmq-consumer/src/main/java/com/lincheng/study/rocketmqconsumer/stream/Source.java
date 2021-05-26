package com.lincheng.study.rocketmqconsumer.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author linCheng
 * @date 2021/5/26 14:07
 */
public interface Source {

    @Input("erbadagang-input")
    SubscribableChannel erbadagangInput();

    @Input("trek-input")
    SubscribableChannel trekInput();

}

