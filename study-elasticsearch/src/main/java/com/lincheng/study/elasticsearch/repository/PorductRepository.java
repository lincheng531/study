package com.lincheng.study.elasticsearch.repository;

import com.lincheng.study.elasticsearch.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author linCheng
 * @date 2021/4/20 11:42
 */
@Repository
public interface PorductRepository extends ElasticsearchRepository<Product,Long> {

}
