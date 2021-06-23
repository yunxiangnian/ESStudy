package com.cloud.es.doc;

import com.cloud.es.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author lisw
 * @create 2021/6/23 14:38
 */
public class ESClient_Doc_Search {
    public static void main(String[] args) throws Exception{
        RestHighLevelClient client= new RestHighLevelClient(
                RestClient.builder(new HttpHost(("localhost"),9200)));
        /**查询数据*/
        GetRequest request = new GetRequest();
        request.index("user").id("1001");

        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println("结果为：" + response.getSourceAsString());

        client.close();
    }
}
