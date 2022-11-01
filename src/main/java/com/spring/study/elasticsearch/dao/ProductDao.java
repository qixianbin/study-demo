package com.spring.study.elasticsearch.dao;

import com.spring.study.elasticsearch.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Qi
 * @description
 * @date 2022/8/19 6:26
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product, Long> {
}
