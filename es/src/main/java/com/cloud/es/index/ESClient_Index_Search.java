package com.cloud.es.index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * @author lisw
 * @create 2021/6/23 13:47
 */
public class ESClient_Index_Search {
    public static void main(String[] args) throws Exception{
        RestHighLevelClient client= new RestHighLevelClient(
                RestClient.builder(new HttpHost(("localhost"),9200)));

        /**创建索引请求*/
        GetIndexRequest request = new GetIndexRequest("user");

        GetIndexResponse response =
                client.indices().get(request, RequestOptions.DEFAULT);
        System.out.println(response.getAliases());
        System.out.println(response.getMappings());
        System.out.println(response.getSettings());
        client.close();
    }
}
