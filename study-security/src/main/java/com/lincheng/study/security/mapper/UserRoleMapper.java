package com.lincheng.study.security.mapper;

import com.lincheng.study.security.entity.UserRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author linCheng
 * @since 2021-11-10
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleEntity> {

    /**
     * @Description: 通过用户id查询角色编码
     * @author: linCheng
     * @Date: 2021/11/10 16:23
     * @param: custId
     * @Return: java.util.List<java.lang.String>
     */
    List<String> selectRoleCodesByCustId(Long custId);

}
