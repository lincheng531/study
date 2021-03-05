package com.lincheng.study.aliossandhuaweiobs;

import com.alibaba.fastjson.JSON;
import com.obs.services.ObsClient;
import com.obs.services.model.PutObjectResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyAliossandhuaweiobsApplication.class)
public class StudyAliossandhuaweiobsApplicationTests {

    @Test
    public void testOss() throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        //String endpoint = "oss-cn-shenzhen.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        //String accessKeyId = "LTAI4FyvncyJ6Lm8xTo28zKm";
        //String accessKeySecret = "07SQ9WE6MprA07o5etl6ZEBl6a9ufv";

        // 创建OSSClient实例。
        //OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        //InputStream inputStream = new FileInputStream("C:\\Users\\linc\\Desktop\\KICP缓存管理说明\\picture\\两级缓存流程图.jpg");
        //PutObjectResult putObjectResult = ossClient.putObject("gulimall-lincheng", "两级缓存流程图.jpg", inputStream);
        // 关闭OSSClient。
        //ossClient.shutdown();
        //System.out.println("上传成功");
    }


    @Test
    public void testObs() throws IOException {

        String endPoint = "obs.cn-south-1.myhuaweicloud.com";
        String ak = "PR3EYGZCAQ3N2N2ESDCC";
        String sk = "LmLOk8wYXUJcKVaCp6oOGn5gYie6r2Oc3qBBaLTX";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        InputStream inputStream = new FileInputStream("C:\\Users\\linc\\Desktop\\KICP缓存管理说明\\picture\\两级缓存流程图.jpg");

        PutObjectResult putObjectResult = obsClient.putObject("kicp-demo", "images/2021/3/4/2d8c9572-3cb0-4352-9e20-8187d5a7bbb8.jpg", inputStream);

        obsClient.close();
        System.out.println(JSON.toJSONString(putObjectResult));
    }
}
