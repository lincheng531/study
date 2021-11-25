package com.lincheng.study.auth2.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * @Description: 资源
 * @author lincheng5
 * @date 2021/11/14 23:52
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("getCurrentUser")
    public Object getCurrentUser(Authentication authentication, HttpServletRequest httpServletRequest){
        String authorization = httpServletRequest.getHeader("Authorization");
        String token = authorization.substring(authorization.indexOf("Bearer") + 7);
        return Jwts.parser()
                .setSigningKey("xxxx".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
    }
}
