package com.lincheng.study.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.lincheng.study.elasticsearch.entity.Product;
import com.lincheng.study.elasticsearch.repository.PorductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linCheng
 * @date 2021/4/20 11:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyElasticsearchApplication.class)
public class SpringDataElasticsearchTest {

    //注入 ElasticsearchRestTemplate
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private PorductRepository porductRepository;

    //创建索引并增加映射配置
    @Test
    public void createIndex(){
        //创建索引，系统初始化会自动创建索引
        System.out.println("创建索引");
    }

    @Test
    public void deleteIndex(){
        //创建索引，系统初始化会自动创建索引
        boolean flg = elasticsearchRestTemplate.deleteIndex(Product.class);
        System.out.println("删除索引 = " + flg);
    }


    @Test
    public void testSave(){
        Product product = new Product();
        product.setId(2L);
        product.setTitle("华为手机");
        product.setCategory("手机");
        product.setPrice(2999.0);
        product.setImages("http://www.atguigu/hw.jpg");
        porductRepository.save(product);
    }

    @Test
    public void testUpdate(){
        Product product = new Product();
        product.setId(1L);
        product.setTitle("小米 2 手机");
        product.setCategory("手机");
        product.setPrice(9999.0);
        product.setImages("http://www.atguigu/xm.jpg");
        porductRepository.save(product);
    }

    //根据 id 查询
    @Test
    public void findById(){
        Product product = porductRepository.findById(1L).orElse(null);
        System.out.println(JSON.toJSONString(product));
    }


    @Test
    public void findAll(){
        Iterable<Product> products = porductRepository.findAll();
        ArrayList<Product> productArrayList = Lists.newArrayList(products);
        System.out.println(JSON.toJSONString(productArrayList));
    }

    //删除
    @Test
    public void delete(){
        Product product = new Product();
        product.setId(1L);
        porductRepository.delete(product);
    }
    //批量新增
    @Test
    public void saveAll(){
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId((long) i);
            product.setTitle("["+i+"]小米手机");
            product.setCategory("手机");
            product.setPrice(1999.0+i);
            product.setImages("http://www.atguigu/xm.jpg");
            productList.add(product);
        }
        porductRepository.saveAll(productList);
    }
    //分页查询
    @Test
    public void findByPageable(){
        //设置排序(排序方式，正序还是倒序，排序的 id)
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        int currentPage=0;//当前页，第一页从 0 开始，1 表示第二页
        int pageSize = 5;//每页显示多少条
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage,pageSize,sort);
        //分页查询
        Page<Product> productPage = porductRepository.findAll(pageRequest);
        for (Product Product : productPage.getContent()) {
            System.out.println(Product);
        }
    }
}
