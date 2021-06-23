package com.cloud.es.doc;

import com.cloud.es.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
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
public class ESClient_Doc_Insert {
    public static void main(String[] args) throws Exception{
        RestHighLevelClient client= new RestHighLevelClient(
                RestClient.builder(new HttpHost(("localhost"),9200)));
        /**插入数据*/
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");
        User user = new User();
        user.setName("lisi");
        user.setGender("男");
        user.setAge(20);

        /**ES支持JSON格式数据*/
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        /**显式说明数据类型是JSON*/
        request.source(userJson, XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println("插入结果为：" + response.getResult());

        client.close();
    }
}
