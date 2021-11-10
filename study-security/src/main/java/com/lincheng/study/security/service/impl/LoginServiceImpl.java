package com.lincheng.study.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lincheng.study.security.entity.CustEntity;
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

        QueryWrapper<CustEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("MOBILE",mobile);
        CustEntity custEntity = custMapper.selectOne(queryWrapper);
        if (!Optional.ofNullable(custEntity).isPresent()){
            throw new UsernameNotFoundException("用户不存在");
        }

        String encode = passwordEncoder.encode(custEntity.getPassword());

        return new User(custEntity.getMobile(),encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }


}
