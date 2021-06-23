package com.cloud.es.doc;

import com.cloud.es.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author lisw
 * @create 2021/6/23 14:38
 */
public class ESClient_Doc_Update {
    public static void main(String[] args) throws Exception{
        RestHighLevelClient client= new RestHighLevelClient(
                RestClient.builder(new HttpHost(("localhost"),9200)));
        /**修改数据*/
        UpdateRequest request = new UpdateRequest();
        request.index("user").id("1001");

        /**显式说明数据类型是JSON*/
        request.doc(XContentType.JSON, "sex","女");
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println("修改结果为：" + response.getResult());

        client.close();
    }
}
