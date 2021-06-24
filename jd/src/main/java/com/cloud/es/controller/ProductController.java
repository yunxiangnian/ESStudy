package com.cloud.es.controller;

import com.cloud.es.entities.Product;
import com.cloud.es.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author lisw
 * @create 2021/6/24 17:53
 */
@RestController
public class ProductController {
    @Resource
    private ProductService productService;


    @GetMapping({"/parse/{keywords}"})
    public String parseJD(@PathVariable("keywords")String keywords) throws IOException {
        productService.parseProduct(keywords);
        return "{'code':200,'msg':'成功'}";
    }


    @GetMapping("/get/{keywords}")
    public Iterable<Product> getByKeywords(@PathVariable("keywords")String keywords) throws IOException {
        Iterable<Product> products = productService.getByKeywords(keywords);
        return products;
    }

}
