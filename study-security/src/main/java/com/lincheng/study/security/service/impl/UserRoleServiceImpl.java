package com.lincheng.study.security.service.impl;

import com.lincheng.study.security.entity.UserRoleEntity;
import com.lincheng.study.security.mapper.UserRoleMapper;
import com.lincheng.study.security.service.interfaces.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linCheng
 * @since 2021-11-10
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements IUserRoleService {

}
