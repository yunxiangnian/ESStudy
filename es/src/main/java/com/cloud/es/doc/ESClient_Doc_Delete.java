package com.cloud.es.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author lisw
 * @create 2021/6/23 14:38
 */
public class ESClient_Doc_Delete {
    public static void main(String[] args) throws Exception{
        RestHighLevelClient client= new RestHighLevelClient(
                RestClient.builder(new HttpHost(("localhost"),9200)));
        /**插入数据*/
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");

        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println("结果为：" + response.getResult());

        client.close();
    }
}
