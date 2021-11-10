package com.lincheng.study.security.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author linCheng
 * @since 2021-11-10
 */
@Getter
@Setter
@TableName("sys_role")
public class RoleEntity extends Model<RoleEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId(value = "ROLE_ID", type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色编码
     */
    @TableField("ROLE_CODE")
    private String roleCode;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 0:失效,1:生效
     */
    @TableField("STATE")
    @TableLogic
    private Integer state;


    @Override
    public Serializable pkVal() {
        return this.roleId;
    }

}
