package com.lincheng.study.security.config;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;

/**
 * @Description: 自定义登录成功跳转
 * @author lincheng5
 * @date 2021/11/10 23:26
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final String url;

    public MyAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println(JSON.toJSONString(authentication.getAuthorities()));
        //基于安全考虑，显示null
        System.out.println(JSON.toJSONString(authentication.getCredentials()));
        System.out.println(JSON.toJSONString(authentication.getDetails()));
        System.out.println(JSON.toJSONString(authentication.getPrincipal()));
        //如果是前后分离。只要告知登录成功，不用再转发地址。
        httpServletResponse.sendRedirect(url);
    }
}
