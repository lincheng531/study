package com.lincheng.study.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lincheng.study.security.entity.CustEntity;
import com.lincheng.study.security.entity.RoleEntity;
import com.lincheng.study.security.entity.UserRoleEntity;
import com.lincheng.study.security.mapper.CustMapper;
import com.lincheng.study.security.mapper.RoleMapper;
import com.lincheng.study.security.mapper.UserRoleMapper;
import com.lincheng.study.security.service.interfaces.ILoginService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lincheng5
 * @date 2021/11/9 23:26
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private CustMapper custMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {

        //查询用户
        QueryWrapper<CustEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("MOBILE",mobile);
        CustEntity custEntity = custMapper.selectOne(queryWrapper);
        if (!Optional.ofNullable(custEntity).isPresent()){
            throw new UsernameNotFoundException("用户不存在");
        }

        //配置权限
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        List<String> roleCodes = userRoleMapper.selectRoleCodesByCustId(custEntity.getCustId());
        if (!CollectionUtils.isEmpty(roleCodes)) {
            roleCodes.forEach(roleCode -> {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleCode);
                authorities.add(simpleGrantedAuthority);
            });
        }else {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("normal");
            authorities.add(simpleGrantedAuthority);
        }

        //手动加角色编码
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_authorityRole");
        authorities.add(simpleGrantedAuthority);

        //手动加请求路径
        SimpleGrantedAuthority simpleGrantedAuthority1 = new SimpleGrantedAuthority("/main.html");
        authorities.add(simpleGrantedAuthority1);


        String encode = passwordEncoder.encode(custEntity.getPassword());

        //List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal");
        return new User(custEntity.getMobile(),encode, authorities);
    }


}
