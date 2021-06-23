package com.cloud.es.index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

/**
 * @author lisw
 * @create 2021/6/23 13:47
 */
public class ESClient_Index_Create {
    public static void main(String[] args) throws Exception{
        RestHighLevelClient client= new RestHighLevelClient(
                RestClient.builder(new HttpHost(("localhost"),9200)));

        /**创建索引请求*/
        CreateIndexRequest request = new CreateIndexRequest("user");
        //创建索引
        CreateIndexResponse response =
                client.indices().create(request, RequestOptions.DEFAULT);
        boolean b = response.isAcknowledged();
        System.out.println("索引操作：" + b);

        client.close();
    }
}
