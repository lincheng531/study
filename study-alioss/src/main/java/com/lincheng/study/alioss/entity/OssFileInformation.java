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
@Table(name = "oss_file_info")
public class OssFileInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ossFileInfoId;

    private Integer fileType;

    private String ossFileName;

    private String fileName;

    private String md5Hex;

    private String url;

    private Long fileSize;

    private String remark;

    private Date addTime;

    private Date modifyTime;

    private Long operatorId;

    private String operatorName;


}
