package com.lincheng.study.dubbo.service.impl;

import com.lincheng.study.common.api.ProductService;
import com.lincheng.study.common.domain.dubbo.vo.ProductVO;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author linCheng
 * @date 2021/4/27 10:16
 */

//暴露接口
@DubboService
@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public ProductVO getProduct(){

        ProductVO productVO = new ProductVO();
        productVO.setId(1L);
        productVO.setName("测试dubbo");
        productVO.setPrice(23.2);

        return productVO;
    }


    public static void main(String[] args) {

        //SimpleDateFormat dateFormat = new SimpleDateFormat("STA(dd/MM/yyyy HH:mm)");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        System.out.println(dateFormat.format(new Date()));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());

    }


}
