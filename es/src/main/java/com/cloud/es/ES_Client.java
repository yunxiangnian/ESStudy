package com.cloud.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author lisw
 * @create 2021/6/23 14:09
 */
public class ES_Client {
    public static void main(String[] args) throws Exception{
        // 在7.X之后已经弃用了原来的客户端类，将会采用POM文件中引入的更高级别的客户端 RestHighLevelClient
        RestHighLevelClient client= new RestHighLevelClient(
                RestClient.builder(new HttpHost(("localhost"),9200)));
        client.close();
    }
}
