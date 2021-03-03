package com.lincheng.study.alioss.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "oss_file_business")
public class OssFileBusiness {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
