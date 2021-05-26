package com.lincheng.study.rocketmqproduct.controller;

import com.lincheng.study.common.domain.rocket.vo.MessageVO;
import com.lincheng.study.rocketmqproduct.stream.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linCheng
 * @date 2021/5/26 13:52
 */
@RestController
public class ProductController {

    @Autowired
    private Source source;

    @RequestMapping("/product/message")
    public void productMessage(){
        MessageVO messageVO = new MessageVO();
        messageVO.setId(1);
        messageVO.setContext("测试rocket_1");

        Message<MessageVO> messageVOMessage = MessageBuilder.withPayload(messageVO)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();

        source.erbadagangOutput().send(messageVOMessage);
    }
}
