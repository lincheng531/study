package com.lincheng.study.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author linCheng
 * @date 2021/4/20 11:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//分片为3，副本为1
@Document(indexName = "product", shards = 3, replicas = 1)
/**
 * type : 字段数据类型
 * analyzer : 分词器类型
 * index : 是否索引(默认:true),不能用来查询
 * Keyword : 短语,不进行分词
 */
public class Product {
    //商品唯一标识
    @Id
    private Long id;

    //分类名称
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String category;


    //商品名称
    @Field(type = FieldType.Keyword)
    private String title;


    //商品价格
    @Field(type = FieldType.Double)
    private Double price;


    //图片地址
    @Field(type = FieldType.Keyword, index = false)
    private String images;
}
