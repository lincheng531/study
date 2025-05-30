package com.lincheng.study.rocketmqconsumer.stream;

import com.lincheng.study.common.domain.rocket.vo.MessageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author linCheng
 * @date 2021/5/26 14:10
 */
@Component
public class MqListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener("erbadagang-input")
    public void onMessage(@Payload MessageVO message) {
        System.out.println("哈哈哈");
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
