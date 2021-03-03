package com.lincheng.study.common.domain.alioss.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OssFileBusinessVO implements Serializable {

    private static final long serialVersionUID = 5688317378214483353L;

    private Long ossFileBusinessId;

    private Long ossFileInfoId;

    private String businessId;

    private Integer businessType;

    private Long userId;

    private Long robotId;

    private String remark;

    private Date addTime;

    private Date modifyTime;

    private Long operatorId;

    private String operatorName;

}
