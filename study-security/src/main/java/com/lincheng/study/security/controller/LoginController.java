package com.lincheng.study.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lincheng5
 * @date 2021/11/8 23:31
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "redirect:main.html";
    }
}
