package com.lincheng.study.dubbo.controller;

import com.lincheng.study.common.api.ProductService;
import com.lincheng.study.common.domain.dubbo.vo.ProductVO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linCheng
 * @date 2021/4/27 11:00
 */
@RestController
public class ConsumerController {

    @DubboReference(check = false ,timeout = 5 * 1000 ,retries = 0)
    private ProductService productService;

    @RequestMapping("dubbo/getProduct")
    public ProductVO getProduct(){
       return productService.getProduct();
    }
}
