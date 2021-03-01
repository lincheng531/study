package com.lincheng.study.alioss.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import com.google.common.collect.Lists;
import com.lincheng.study.common.utils.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class OssController {

    //@Autowired
    //OSS ossClient;

    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endpoint;

    @Value("${spring.cloud.alicloud.oss.bucket}")
    private String bucket;

    @Value("${spring.cloud.alicloud.access-key}")
    private String accessKeyId;

    @Value("${spring.cloud.alicloud.secret-key}")
    private String accessKeySecret;

    private static List<String> imageTyep= Lists.newArrayList("jpg", "jpeg", "gif", "png", "bmp");

    @RequestMapping("oss/upload")
    public R ossUpload(@RequestParam("file") MultipartFile file) throws Exception {
        return this.upload(file);
    }

    @RequestMapping("oss/download")
    public void ossDownload(@RequestParam("fileName") String fileName, HttpServletResponse response) throws IOException {
        //通知浏览器以附件形式下载
        //response.reset();// 清空输出流
        //response.setContentType("application/ms-excel;charset=utf-8");

        String name = "测试名称.jpg";
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String(name.getBytes("UTF-8"), "ISO-8859-1"));
        this.exportOssFile(response.getOutputStream(),fileName);
    }

    @RequestMapping("oss/delete")
    @ResponseBody
    public R ossDelete(@RequestParam("fileName") String fileName)
            throws Exception {
        return this.delete(fileName);
    }


    private String getFilePath(String sourceFileName) {
        LocalDateTime dt = LocalDateTime.now();
        return "images/" + dt.getYear()
                + "/" + dt.getMonthValue() + "/"
                + dt.getDayOfMonth() + "/"
                + UUID.randomUUID().toString() + "."
                + StringUtils.substringAfterLast(sourceFileName, ".");
    }

    /**
     * @author: linCheng
     * @description: 下载文件
     * @date: 2021/2/26 17:14
     * @param os
     * @param objectName
     * @return
     */
    public void exportOssFile(OutputStream os, String objectName) throws IOException {
        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        OSSObject ossObject = ossClient.getObject(bucket, objectName);
        // 读取文件内容。
        BufferedInputStream in = new BufferedInputStream(ossObject.getObjectContent());
        BufferedOutputStream out = new BufferedOutputStream(os);
        byte[] buffer = new byte[1024];
        int lenght = 0;
        while ((lenght = in.read(buffer)) != -1) {
            out.write(buffer, 0, lenght);
        }
        if (out != null) {
            out.flush();
            out.close();
        }
        if (in != null) {
            in.close();
        }
    }

    /**
     * @author: linCheng
     * @description: 文件上传
     * @date: 2021/2/26 17:11
     * @param uploadFile
     * @return
     */
    public R upload(MultipartFile uploadFile) {
        // 校验图片格式
        boolean isLegal = false;
        for (String type : imageTyep) {
            if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
                isLegal = true;
                break;
            }
        }
        //封装Result对象，并且将文件的byte数组放置到result对象中
        if (!isLegal) {
            return R.error("error");
        }
        //文件新路径
        String fileName = uploadFile.getOriginalFilename();
        String filePath = getFilePath(fileName);
        // 上传到阿里云
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            PutObjectResult putObjectResult = ossClient.putObject(bucket, filePath,  new ByteArrayInputStream(uploadFile.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            //上传失败
        }
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("status","done");
        hashMap.put("response","success");
        //this.aliyunConfig.getUrlPrefix() + filePath 文件路径需要保存到数据库
        hashMap.put("filePath",filePath);
        return R.ok().put("data",hashMap);
    }



    /**
     * @author: linCheng
     * @description: 删除文件
     * @date: 2021/2/26 17:18
     * @param objectName
     * @return
     */
    public R delete(String objectName) {
        // 根据BucketName,objectName删除文件
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.deleteObject(bucket, objectName);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("status","removed");
        hashMap.put("response","success");
        hashMap.put("name",objectName);
        return R.ok().put("data",hashMap);
    }



}
