package com.lincheng.study.common.domain.alioss.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OssFileInformationVO implements Serializable {

    private static final long serialVersionUID = 3728716391005779976L;

    private Long id;

    private Integer fileType;

    private String ossFileName;

    private String fileName;

    private String md5Hex;

    private String remark;

    private Date addTime;

    private Date modifyTime;

    private Long operatorId;

    private String operatorName;
}
