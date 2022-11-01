package com.spring.study.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @author Qi
 * @description
 * @date 2022/8/11 22:14
 */
public class MyElasticSearch {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient highLevelClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.174.131",9200)));
        try{
            //创建索引的请求
//            CreateIndexRequest user = new CreateIndexRequest("user");
//            CreateIndexResponse indexResponse = highLevelClient.indices().create(user, RequestOptions.DEFAULT);
//            System.out.println(indexResponse.isAcknowledged());

            //查询索引请求
//            GetIndexRequest getIndexRequest = new GetIndexRequest("user");
//            GetIndexResponse indexResponse = highLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);
//            System.out.println("index = " + indexResponse.getIndices());
//            System.out.println("Indices = " + indexResponse.getIndices());
//            System.out.println("mapping = " + indexResponse.getMappings());

            //删除索引请求
//            DeleteIndexRequest deleteIndex = new DeleteIndexRequest("user");
//            AcknowledgedResponse delete = highLevelClient.indices().delete(deleteIndex, RequestOptions.DEFAULT);
//            System.out.println(delete.isAcknowledged());

            //添加数据、多次执行会进行替换更新
            //创建请求
//            IndexRequest indexRequest = new IndexRequest();
//            indexRequest.index("user").id("1001");
//            //创建对象
//            User user = new User();
//            user.setUserName("张三");
//            user.setAge(22);
//            user.setId(1001);
//            //将对象转为json
//            ObjectMapper mapper = new ObjectMapper();
//            String value = mapper.writeValueAsString(user);
//            //将json放入到请求体中，需要设置为json格式
//            IndexRequest source = indexRequest.source(value, XContentType.JSON);
//            //执行请求
//            IndexResponse response = highLevelClient.index(indexRequest, RequestOptions.DEFAULT);
//            //返回结果
//            System.out.println(response.getResult());

            //更新数据-局部更新
//            UpdateRequest request = new UpdateRequest();
//            request.index("user").id("1001");
//            request.doc(XContentType.JSON,"userName","李四");
//            UpdateResponse response = highLevelClient.update(request, RequestOptions.DEFAULT);
//            System.out.println(response.getResult());

            //查询数据
//            GetRequest getRequest = new GetRequest();
//            getRequest.index("user").id("1001");
//            GetResponse response = highLevelClient.get(getRequest, RequestOptions.DEFAULT);
//            System.out.println(response.getSourceAsString());

            //删除数据
//            DeleteRequest deleteRequest = new DeleteRequest();
//            deleteRequest.index("user").id("1001");
//            DeleteResponse response = highLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
//            System.out.println(response.getResult());

            //批量插入数据
            //创建批量插入的请求
//            BulkRequest bulkRequest = new BulkRequest();
//            //创建10个数据请求并添加到批量请求中
//            for (int i = 0; i < 10; i++){
//                IndexRequest indexRequest = new IndexRequest();
//                indexRequest.index("user").id("100" + i);
//                //创建对象
//                User user = new User();
//                user.setUserName("张三" + i);
//                user.setAge(22 + i);
//                user.setId(1000 + i);
//                //将对象转为json
//                ObjectMapper mapper = new ObjectMapper();
//                String value = mapper.writeValueAsString(user);
//                //将单条数据放入请求中
//                indexRequest.source(value,XContentType.JSON);
//                //将单个数据请求放入批量请求中
//                bulkRequest.add(indexRequest);
//            }
//
//            //执行请求
//            BulkResponse response = highLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
//            //返回结果
//            System.out.println(response.getTook());

            //批量删除数据
            //创建批量删除的请求
//            BulkRequest bulkRequest = new BulkRequest();
//            //创建5个删除数据请求并添加到批量请求中
//            for (int i = 0; i < 5; i++){
//                DeleteRequest deleteRequest = new DeleteRequest();
//                deleteRequest.index("user").id("100" + i);
//                //将单个删除数据请求放入批量请求中
//                bulkRequest.add(deleteRequest);
//            }
//
//            //执行请求
//            BulkResponse response = highLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
//            //返回结果
//            System.out.println(response.getTook());

            //高级查询
            SearchRequest searchRequest = new SearchRequest();
            searchRequest.indices("user");

            SearchSourceBuilder builder = new SearchSourceBuilder();
            //使用matchAll查询所有数据
//            builder.query(QueryBuilders.matchAllQuery());
            //使用term查询
//            builder.query(QueryBuilders.termQuery("age","28"));
            //多条件查询
            BoolQueryBuilder query = QueryBuilders.boolQuery();
            //must条件
            query.must(QueryBuilders.matchQuery("userName","张三"));
            query.must(QueryBuilders.matchQuery("age","30"));
            //should条件
//            query.should(QueryBuilders.matchQuery("userName","6"));
//            query.should(QueryBuilders.matchQuery("age","29"));
            //范围查询
//            RangeQueryBuilder query = QueryBuilders.rangeQuery("age");
//            query.gte("29");
            //模糊查询
//            FuzzyQueryBuilder query = QueryBuilders.fuzzyQuery("userName", "张");

            //高亮显示
//            HighlightBuilder highlight = new HighlightBuilder();
//            highlight.preTags("<font color = 'red'>");
//            highlight.postTags("</font>");
//            highlight.field("userName");
//            builder.highlighter(highlight);
            //分页查询
//            builder.from(2).size(2);
            //排序
//            builder.sort("age", SortOrder.DESC);
            //查询结果中只显示哪些field
//            builder.fetchSource(new String[]{"userName","id"}, new String[]{"id"});
            builder.query(query);
            searchRequest.source(builder);
            SearchResponse response = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            for (int i = 0; i < hits.length; i++) {
                System.out.println(hits[i].getSourceAsString());
            }

        }finally {
            highLevelClient.close();
        }
    }
}
