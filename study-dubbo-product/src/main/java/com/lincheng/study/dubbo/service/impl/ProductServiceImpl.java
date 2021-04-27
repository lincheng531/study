package com.lincheng.study.dubbo.service.impl;

import com.lincheng.study.common.api.ProductService;
import com.lincheng.study.common.domain.dubbo.vo.ProductVO;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

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
}
