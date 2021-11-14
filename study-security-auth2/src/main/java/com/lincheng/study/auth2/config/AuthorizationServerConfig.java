package com.lincheng.study.auth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.annotation.Resource;

/**
 * @Description: 授权服务器配置类
 * @author lincheng5
 * @date 2021/11/14 23:39
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private PasswordEncoder passwordEncoder;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //clientId
                .withClient("admin")
                //client password
                .secret(passwordEncoder.encode("112233"))
                //重定向地址，获取授权码
                .redirectUris("https://www.baidu.com")
                //授权范围
                .scopes("all")
                //授权类型
                .authorizedGrantTypes("authorization_code")
        ;

    }
}
