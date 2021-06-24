package com.cloud.es.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author lisw
 * @create 2021/6/24 17:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product", shards = 3, replicas = 1)
public class Product {
    @Id
    private Long id;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Keyword, index = false)
    private String img;
    @Field(type = FieldType.Keyword)
    private String price;
}
