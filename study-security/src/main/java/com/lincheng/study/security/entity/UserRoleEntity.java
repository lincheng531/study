package com.lincheng.study.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sys_user_role")
public class UserRoleEntity extends Model<UserRoleEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色信息关联主键
     */
    @TableId(value = "USER_ROLE_ID", type = IdType.AUTO)
    private Long userRoleId;

    /**
     * 角色id
     */
    @TableField("ROLE_ID")
    private Long roleId;

    /**
     * 用户id
     */
    @TableField("CUST_ID")
    private Long custId;

    /**
     * 0:失效,1:生效
     */
    @TableField("STATE")
    @TableLogic
    private Integer state;


    @Override
    public Serializable pkVal() {
        return null;
    }

}
