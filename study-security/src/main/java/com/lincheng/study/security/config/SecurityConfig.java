package com.lincheng.study.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description:
 *          UsernamePasswordAuthenticationFilter 这个类说明了为什么登录请求要用post与username,passward
 *
 *          antMatchers:
 *                  参数是不定向参数，每个参数是一个ant表达式，用于匹配URL规则。
 *                   规则如下:
 *                      ?:匹配一个字符
 *                      *:匹配0个或多个字符
 *                      **:匹配0个或多个目录
 * @author lincheng5
 * @date 2021/11/9 0:00
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单登录
        http.formLogin()
                //自定义页面
                .loginPage("/login.html")
                //自定义登录逻辑
                .loginProcessingUrl("/login")
                //登录成功后的主页面,必须是post请求
                //.successForwardUrl("/toMain")
                .successHandler(new MyAuthenticationSuccessHandler("https://www.baidu.com"))
                //登录成功后的主页面,必须是post请求
                //.failureForwardUrl("/toError")
                .failureHandler(new MyAuthenticationFailureHandler("https://fanyi.baidu.com"))
                //自定义登录用户名参数
                //.usernameParameter("userName")
                //自定义登录密码参数
                //.passwordParameter("passWard");
                ;
        //授权
        http.authorizeRequests()
                //放行登录页面
                .antMatchers("/login.html").permitAll()
                //放行登录失败页面
                .antMatchers("/error.html").permitAll()
                //.antMatchers("/image/**").permitAll()
                //.antMatchers( "/**/*.jpg").permitAll()
                //所有的请求都必须被认证（登录）
                .anyRequest().authenticated();

        //关闭csrf防护
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
