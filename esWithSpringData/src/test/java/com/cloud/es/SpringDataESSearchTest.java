package com.cloud.es;

import com.cloud.es.dao.ProductDao;
import com.cloud.es.entities.Product;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author lisw
 * @create 2021/6/24 16:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESSearchTest {
    @Resource
    private ProductDao productDao;

    /**
     * term查询
     * search(termQueryBuilder)调用搜索方法，参数查询构建器对象
     */
    @Test
    public void termQuery()
    {
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", " 小米 ");
        Iterable<Product> products = productDao.search(termQueryBuilder);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
