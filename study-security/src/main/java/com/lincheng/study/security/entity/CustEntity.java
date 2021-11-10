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
@TableName("c_cust")
public class CustEntity extends Model<CustEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识
     */
    @TableId(value = "CUST_ID", type = IdType.AUTO)
    private Long custId;

    /**
     * 手机号
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 用户名称
     */
    @TableField("CUST_NAME")
    private String custName;

    /**
     * 用户类型
     */
    @TableField("CUST_TYPE")
    private String custType;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 状态;0为失效，1:为生效
     */
    @TableField("STATE")
    @TableLogic(delval = "0",value = "1")
    private Integer state;


    @Override
    public Serializable pkVal() {
        return this.custId;
    }

}
