package com.lincheng.study.session.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-28 16:00
 **/
@RestController
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/testSession")
    public void test(HttpSession session){
        session.setAttribute("testSession","999999");
    }


}
