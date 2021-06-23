package com.cloud.es.multi;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import sun.net.idn.StringPrep;

import javax.swing.text.Highlighter;

/**
 * @author lisw
 * @create 2021/6/23 15:18
 */
public class ESClient_Doc_Query {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient client= new RestHighLevelClient(
                RestClient.builder(new HttpHost(("localhost"),9200)));
        /**查询数据*/
       /*
        SearchRequest request = new SearchRequest();
        request.indices("user");

        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        */
       /**获取符合条件的结果*/
       /*
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits){
            System.out.println(hit.getSourceAsString());
        }
        client.close();
        */

        /**条件查询 termQuery*/
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
        /**查询 name 为 lisi 的数据*/
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("name", "lisi")));
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        /**获取符合条件的结果*/
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//        client.close();


//        /**分页查询 和排序 */
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        /**查询 name 为 lisi 的数据*/
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.termQuery("name", "lisi"));
//        /** 查询页数的公式 (页码-1) * 每页的个数 */
//        /** 同时也可排序 SortOrder.DESC 降序*/
//        builder.from(0).size(2).sort("age", SortOrder.DESC);
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        /**获取符合条件的结果*/
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//        client.close();

//        /**过滤字段 显示只想要显示的*/
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        /**查询 name 为 lisi 的数据*/
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.termQuery("name", "lisi"));
//        String[] includes = {"name"};
//        String[] excludes = {};
//        /**过滤字段方法 */
//        builder.fetchSource(includes, excludes);
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        /**获取符合条件的结果*/
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//        client.close();

//        /** 组合查询 */
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        /**生成组合查询条件*/
//        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//        queryBuilder.must(QueryBuilders.matchQuery("name", "lisi"));
//        queryBuilder.must(QueryBuilders.matchQuery("age", 20));
//        /**将组合查询条件放入查询Builder中*/
//        builder.query(queryBuilder);
//
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        /**获取符合条件的结果*/
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//        client.close();

//          /**范围查询 */
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        /**生成组合查询条件*/
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//        // 大于等于
//        rangeQuery.gte(20);
//        //小于等于
//        rangeQuery.lte(40);
//
//        builder.query(rangeQuery);
//
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        /**获取符合条件的结果*/
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//        client.close();

//        /**模糊查询 */
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        /**生成模糊查询条件  也就是全文检索（分词查询）*/
//        builder.query(QueryBuilders.fuzzyQuery("name","lisi").fuzziness(Fuzziness.ONE));
//
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        /**获取符合条件的结果*/
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//        client.close();

//        /**高亮查询 */
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        /**生成高亮查询条件  也就是全文检索（分词查询）*/
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "lisi");
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        /**前缀标签 后缀标签*/
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//
//        builder.highlighter(highlightBuilder);
//        builder.query(termQueryBuilder);
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        /**获取符合条件的结果*/
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//        client.close();


//        /**聚合查询 最大值查询*/
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        /**对age字段取最大值*/
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//
//
//        builder.aggregation(aggregationBuilder);
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        /**获取符合条件的结果*/
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//        client.close();

        /**分组查询*/
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        /**对age字段分组查询*/
        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");

        builder.aggregation(aggregationBuilder);
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        /**获取符合条件的结果*/
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits){
            System.out.println(hit.getSourceAsString());
        }
        client.close();
    }
}
