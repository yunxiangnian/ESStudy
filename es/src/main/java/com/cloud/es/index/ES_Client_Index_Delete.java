package com.cloud.es.index;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

/**
 * @author lisw
 * @create 2021/6/23 14:09
 */
public class ES_Client_Index_Delete {
    public static void main(String[] args) throws Exception{
        RestHighLevelClient client= new RestHighLevelClient(
                RestClient.builder(new HttpHost(("localhost"),9200)));
        /**创建索引请求*/
        DeleteIndexRequest request = new DeleteIndexRequest("user");
        //创建索引
        AcknowledgedResponse response =
                client.indices().delete(request, RequestOptions.DEFAULT);
        boolean b = response.isAcknowledged();
        System.out.println("索引操作：" + b);


        client.close();
    }
}
