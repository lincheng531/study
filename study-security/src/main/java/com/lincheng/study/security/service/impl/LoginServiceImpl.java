package com.lincheng.study.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lincheng.study.security.entity.Cust;
import com.lincheng.study.security.mapper.CustMapper;
import com.lincheng.study.security.service.interfaces.ILoginService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author lincheng5
 * @date 2021/11/9 23:26
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private CustMapper custMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {

        QueryWrapper<Cust> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("MOBILE",mobile);
        Cust cust = custMapper.selectOne(queryWrapper);
        if (!Optional.ofNullable(cust).isPresent()){
            throw new UsernameNotFoundException("用户不存在");
        }

        String encode = passwordEncoder.encode(cust.getPassword());

        return new User(cust.getMobile(),encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }


}
