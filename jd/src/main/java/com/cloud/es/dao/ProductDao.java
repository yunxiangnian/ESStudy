package com.cloud.es.dao;

import com.cloud.es.entities.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lisw
 * @create 2021/6/24 18:03
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product,Long> {
}
