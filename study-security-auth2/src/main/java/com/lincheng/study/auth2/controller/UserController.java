package com.lincheng.study.auth2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 资源
 * @author lincheng5
 * @date 2021/11/14 23:52
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
        return authentication;
    }
}
