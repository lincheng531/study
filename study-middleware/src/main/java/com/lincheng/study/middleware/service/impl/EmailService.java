package com.lincheng.study.middleware.service.impl;

import com.lincheng.study.middleware.service.IEmailService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-01-07 09:58
 **/
@Service
public class EmailService implements IEmailService {


    @Value("${spring.mail.username}")
    private String fromEmail;

    //注入spring发送邮件的对象
    @Resource
    private JavaMailSender javaMailSender;



    @Override
    public boolean sendAttachmentMail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setFrom(fromEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        try {
            javaMailSender.send(simpleMailMessage);  		//执行发送
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sendAttachmentMail(List<String> toUser, String subject, String content, List<String> filepath) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setTo(toUser.toArray(new String[0]));
            helper.setSubject(subject);
            helper.setText(content);
            helper.setFrom(fromEmail);

            if(CollectionUtils.isNotEmpty(filepath)){
                //读取附件文件（传入文件路径）
                for (String filePath : filepath) {
                    //遍历文件数组，实现多个附件的添加
                    FileSystemResource file = new FileSystemResource(new File(filePath));
                    String fileName = file.getFilename();//获取文件名
                    if (StringUtils.isEmpty(fileName)) {
                        continue;
                    }
                    helper.addAttachment(fileName, file);//参数：文件名，文件路径
                }
            }

            try {
                javaMailSender.send(mimeMessage);		//发送邮件
            } catch (Exception e) {
                return false;						//发送出现异常(或者文件路径不对)
            }

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }
}
