package com.lincheng.study.auth2.config;

import com.lincheng.study.auth2.service.interfaces.ILoginService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 授权服务器配置类
 *      http://localhost:8080/oauth/authorize?response_type=code&client_id=admin&redirect_uri=https://www.baidu.com&scope=all
 * @author lincheng5
 * @date 2021/11/14 23:39
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ILoginService loginService;

    //@Resource
    //@Qualifier("redisTokenStore")
    //private TokenStore tokenStore;

    @Resource
    @Qualifier("jwtTokenStore")
    private TokenStore tokenStore;

    @Resource
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Resource
    private TokenEnhancer tokenEnhancer;

    //密码模式
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(tokenEnhancer);
        delegates.add(jwtAccessTokenConverter);
        tokenEnhancerChain.setTokenEnhancers(delegates);

        endpoints
                //自定义登录逻辑
                .userDetailsService(loginService)
                //授权管理器
                .authenticationManager(authenticationManager)
                //令牌存储位置
                .tokenStore(tokenStore)
                .accessTokenConverter(jwtAccessTokenConverter)
                //自定义增强链
                .tokenEnhancer(tokenEnhancerChain)
        ;

    }


    //授权码模式
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //clientId
                .withClient("admin")
                //client password
                .secret(passwordEncoder.encode("112233"))
                //令牌失效时间
                .accessTokenValiditySeconds(36000)
                //刷新令牌失效时间
                .refreshTokenValiditySeconds(184000)
                //重定向地址，获取授权码
                .redirectUris("https://www.baidu.com")
                //授权范围
                .scopes("all")
                //授权类型 authorization_code 授权码模式
                .authorizedGrantTypes("authorization_code","password","refresh_token")
        ;

    }
}
