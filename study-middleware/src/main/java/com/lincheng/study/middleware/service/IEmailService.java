package com.lincheng.study.middleware.service;

import java.util.List;

public interface IEmailService {

    boolean sendAttachmentMail(String to, String subject, String content);

    boolean sendAttachmentMail(List<String> toUser, String subject, String content, List<String> filepath);
}
