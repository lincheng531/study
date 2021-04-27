package com.lincheng.study.common.domain.dubbo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author linCheng
 * @date 2021/4/27 10:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 8533121501366384740L;

    private Long id;

    private String name;

    private Double price;
}
