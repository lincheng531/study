package com.lincheng.study.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lincheng5
 * @date 2021/11/8 23:31
 */
@Controller
public class LoginController {

    @RequestMapping("/studyLogin")
    public String login() {
        return "redirect:main.html";
    }


    @RequestMapping("/toMain")
    //根据角色判断,必须以ROLE_开头，区分大小写
    //@Secured("ROLE_authorityRole")
    //执行前判断，根据角色匹配,ROLE_开头可写可不写，严格区分大小写。和access写法是一样的
    @PreAuthorize("hasRole('authorityRole')")
    public String toMain() {
        return "redirect:/main.html";
    }


    @RequestMapping("/toError")
    public String toError() {
        return "redirect:/error.html";
    }
}
