package com.lincheng.study.security.config;

import com.lincheng.study.security.service.interfaces.ILoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

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
 *          regexMatchers:
 *                  使用正则表达式进行匹配。和antMatchers() 主要的区别就是参数，antMatchers() 参数是ant表达式，
 *                  regexMatchers()参数是正则表达式。
 * @author lincheng5
 * @date 2021/11/9 0:00
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private ILoginService loginService;

    @Resource
    private DataSource dataSource;

    @Resource
    private PersistentTokenRepository tokenRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单登录
        http.formLogin()
                //自定义页面
                .loginPage("/login.html")
                //自定义登录逻辑
                .loginProcessingUrl("/login")
                //登录成功后的主页面,必须是post请求
                .successForwardUrl("/toMain")
                //.successHandler(new MyAuthenticationSuccessHandler("https://www.baidu.com"))
                //登录成功后的主页面,必须是post请求
                .failureForwardUrl("/toError")
                //.failureHandler(new MyAuthenticationFailureHandler("https://fanyi.baidu.com"))
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
                //antMatchers ant表达式，有http请求方式参数
                //.antMatchers("/image/**").permitAll()
                //.antMatchers( HttpMethod.POST,"/**/*.jpg").permitAll()
                //regexMatchers正则表达式，有http请求方式参数
                //.regexMatchers(HttpMethod.POST,".+[.]jpg").permitAll()
                //application.yml中的mvc 请求前缀
                //.mvcMatchers(HttpMethod.POST,"/image/**").servletPath("/xxxx").permitAll()
                //只有登录的用户拥有admin的权限都能访问该请求（区分大小学）。如会员视频，只有会员才能访问
                //.antMatchers("/authority.html").hasAuthority("admin")
                //多权限匹配
                //.antMatchers("/authority.html").hasAnyAuthority("admin","superAdmin")
                //根据角色匹配,不能以ROLE_ 开头，严格区分大小写
                //.antMatchers("/authority.html").hasRole("authorityRole")
                //多角色匹配
                //.antMatchers("/authority.html").hasAnyRole("authorityRole","anyAuthorityRole")
                //根据IP匹配
                //.antMatchers("/authority.html").hasIpAddress("127.0.0.1")
                //所有的请求都必须被认证（登录）
                //.anyRequest().authenticated()
                //自定义access表达式
                //.anyRequest().access("@accessServiceImpl.hasPermission(request,authentication)")
        ;

        //异常处理
        http.exceptionHandling()
                .accessDeniedHandler(new MyAccessDeniedHandler());


        //记住我
        http.rememberMe()
                //自定义记住我参数
                .rememberMeParameter("remember-me")
                //记住的时间默认两周，这里设置一天
                .tokenValiditySeconds(86400)
                //自定义功能实现逻辑
                //.rememberMeServices()
                //自定义登录逻辑
                .userDetailsService(loginService)
                //指定存储位置
                .tokenRepository(tokenRepository)
        ;

        //退出登录
        http.logout()
                //退出登录url
                .logoutUrl("/logout")
                //退出成功页面
                .logoutSuccessUrl("/login.html")
        ;



        //关闭csrf防护
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        //设置数据源
        tokenRepository.setDataSource(dataSource);
        //启动时是否创建表，第一次要，之后注释掉
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }
}

