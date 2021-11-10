package com.lincheng.study.security.config;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 自定义登录失败跳转
 * @author lincheng5
 * @date 2021/11/10 23:26
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final String url;

    public MyAuthenticationFailureHandler(String url) {
        this.url = url;
    }


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //如果是前后分离。只要告知登录失败，不用再转发地址。
        httpServletResponse.sendRedirect(url);
    }
}
