package com.cloud.es.service;

import com.cloud.es.dao.ProductDao;
import com.cloud.es.entities.Product;
import com.cloud.es.utils.HtmlParseUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author lisw
 * @create 2021/6/24 17:53
 */
@Service
public class ProductService {
    @Resource
    private ProductDao productDao;

    /**解析数据*/
    public void parseProduct(String keywords) throws IOException {
        List<Product> products = HtmlParseUtils.ParseJD("java");
        productDao.saveAll(products);
    }

    /**查询标题中包含关键字的文档*/
    public Iterable<Product> getByKeywords(String keywords) throws IOException {
        TermQueryBuilder builder = QueryBuilders.termQuery("title", keywords);
        Iterable<Product> search = productDao.search(builder);
        return search;
    }

}
