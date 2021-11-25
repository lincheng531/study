package com.lincheng.study.sso.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: linCheng
 * @create: 2021-11-25 21:19
 **/
@RestController
@RequestMapping("/sso")
public class SsoController {

    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
        return authentication;
    }
}
