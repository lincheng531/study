package com.lincheng.study.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author linCheng
 * @date 2021/4/20 11:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class product {
    //商品唯一标识
    private Long id;
    //分类名称
    private String category;
    //商品名称
    private String title;
    //商品价格
    private Double price;
    //图片地址
    private String images;
}
