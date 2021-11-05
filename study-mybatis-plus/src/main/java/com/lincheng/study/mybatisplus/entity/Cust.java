package com.lincheng.study.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author linCheng
 * @since 2021-11-05
 */
@Getter
@Setter
@TableName("c_cust")
@ApiModel(value = "Cust对象", description = "")
public class Cust extends Model<Cust> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户唯一标识")
    @TableId(value = "CUST_ID", type = IdType.AUTO)
    private Long custId;

    @ApiModelProperty("手机号")
    @TableField("MOBILE")
    private String mobile;

    @ApiModelProperty("用户名称")
    @TableField("CUST_NAME")
    private String custName;

    @ApiModelProperty("用户类型")
    @TableField("CUST_TYPE")
    private String custType;

    @ApiModelProperty("密码")
    @TableField("PASSWORD")
    private String password;

    @ApiModelProperty("状态;0为失效，1:为生效")
    @TableField("STATE")
    @TableLogic
    private Integer state;


    @Override
    public Serializable pkVal() {
        return this.custId;
    }

}
