package com.lincheng.study.oauth2.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入星期");
        int week = sc.nextInt();
        switch (week){
            case 1:
                System.out.println(1);
            default:
            //case 1,2,3,4,5 -> System.out.println("工作日");
            //case 6,7 -> System.out.println("休息日");
            //default ->  System.out.println("没有这个星期");

        }
    }

}
