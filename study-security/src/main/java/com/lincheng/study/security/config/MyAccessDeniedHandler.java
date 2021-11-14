package com.lincheng.study.security.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lincheng5
 * @date 2021/11/14 17:25
 */

public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setContentType(" application/json; charset=utf-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write("{\"status\": \"403\", \"msg\":\"权限不足，请联系管理员\"}");
        writer.flush();
        writer.close();

    }
}
