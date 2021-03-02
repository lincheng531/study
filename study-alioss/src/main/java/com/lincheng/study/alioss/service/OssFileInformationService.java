package com.lincheng.study.alioss.service;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.lincheng.study.alioss.entity.OssFileInformation;
import com.lincheng.study.alioss.repository.OssFileInformationRepository;
import com.lincheng.study.common.domain.alioss.vo.OssFileInformationVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class OssFileInformationService {

    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endpoint;

    @Value("${spring.cloud.alicloud.oss.bucketName}")
    private String bucketName;

    @Value("${spring.cloud.alicloud.access-key}")
    private String accessKeyId;

    @Value("${spring.cloud.alicloud.secret-key}")
    private String accessKeySecret;


    @Resource
    private OssFileInformationRepository ossFileInformationRepository;



    /**
     * @author: linCheng
     * @description: 文件上传
     * @date: 2021/3/2 14:59
     * @param uploadFile
     * @param fileType
     * @return
     */
    public OssFileInformationVO ossDownload(MultipartFile uploadFile,Integer fileType) throws IOException {

        OssFileInformationVO ossFileInformationVO = new OssFileInformationVO();

        //文件名称
        String fileName = uploadFile.getOriginalFilename();
        //oss文件名称
        String ossfileName = getOssFileName(fileName);
        //文件流
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(uploadFile.getBytes());
        //用于图片去重校验，准备文件空间使用
        String md5Hex = DigestUtils.md5Hex(byteArrayInputStream);


        //通过md5去查询，如果已经存在数据，不在重复保存，直接返回文件信息
        OssFileInformation ossFileInformationByMd5Hex = ossFileInformationRepository.findFirstByMd5Hex(md5Hex);
        if (ossFileInformationByMd5Hex != null){
            BeanUtils.copyProperties(ossFileInformationByMd5Hex,ossFileInformationVO);
            return ossFileInformationVO;
        }


        // 上传到阿里云
        try {
            // 创建OSSClient实例
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（ossfileName）
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, ossfileName,  byteArrayInputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
        } catch (Exception e) {
            //上传失败
            e.printStackTrace();
        }

        OssFileInformation ossFileInformation = OssFileInformation.builder()
                .fileType(fileType)
                .ossFileName(ossfileName)
                .fileName(fileName)
                .md5Hex(md5Hex)
                .addTime(new Date()).build();

        //保存文件信息
        ossFileInformationRepository.save(ossFileInformation);

        BeanUtils.copyProperties(ossFileInformation,ossFileInformationVO);

        return ossFileInformationVO;
    }


    /**
     * @author: linCheng
     * @description: 通过年月日+uuid生成oss中的文件名
     * @date: 2021/3/2 14:19
     * @param sourceFileName
     * @return
     */
    private String getOssFileName(String sourceFileName) {
        LocalDateTime dt = LocalDateTime.now();
        return "images/" + dt.getYear()
                + "/" + dt.getMonthValue() + "/"
                + dt.getDayOfMonth() + "/"
                + UUID.randomUUID().toString() + "."
                + StringUtils.substringAfterLast(sourceFileName, ".");
    }
}
