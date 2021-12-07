package com.lincheng.study.oauth2.service.impl;

import com.lincheng.study.oauth2.pojo.User;
import com.lincheng.study.oauth2.service.interfaces.ILoginService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lincheng5
 * @date 2021/11/9 23:26
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("admin",passwordEncoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }


}
