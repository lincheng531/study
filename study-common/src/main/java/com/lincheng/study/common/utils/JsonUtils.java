package com.lincheng.study.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.lincheng.study.common.domain.alioss.vo.OssFileBusinessVO;
import com.lincheng.study.common.domain.dubbo.vo.ProductVO;

import java.io.IOException;
import java.util.Date;

/**
 * @description: JSON工具类
 * @author: linCheng
 * @create: 2021-10-08 21:36
 **/
public class JsonUtils {

    
    /**
     * @Description: 将对象的大写转换为下划线加小写。
     *                  例如：userName-->user_name
     * @author: linCheng 
     * @Date: 2021/10/8 21:38
     * @param: object
     * @Return: java.lang.String
     * @throws JsonProcessingException
     */
    public static String toUnderlineJSONString(Object object) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.setSerializationInclusion(Include.NON_NULL);
        return mapper.writeValueAsString(object);
    }


    /**
     * @Description: 将下划线转换为驼峰的形式。
     *                  例如：user_name-->userName
     * @author: linCheng
     * @Date: 2021/10/8 21:40
     * @param: json
     * @param: clazz
     * @Return: T
     * @throws IOException
     */
    public static <T> T toSnakeObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return mapper.readValue(json, clazz);
    }


    /**
     * @Description: 首字母大写json串
     * @author: linCheng
     * @Date: 2021/10/8 21:49
     * @param: object
     * @Return: java.lang.String
     */
    public static String initialCapitalizationToJSONString(Object object) {
       return JSON.toJSONString(object,new PascalNameFilter());
    }

    public static void main(String[] args) {

        OssFileBusinessVO ossFileBusinessVO = new OssFileBusinessVO();
        ossFileBusinessVO.setOssFileInfoId(23234L);
        ossFileBusinessVO.setBusinessId("23423");
        ossFileBusinessVO.setOperatorName("l;in");
        System.out.println(initialCapitalizationToJSONString(ossFileBusinessVO));
    }

}
