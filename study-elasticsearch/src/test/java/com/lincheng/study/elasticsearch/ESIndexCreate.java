package com.lincheng.study.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author linCheng
 * @date 2021/4/19 11:52
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyElasticsearchApplication.class)
public class ESIndexCreate {


    @Test
    public void testESIndexCreate() throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

       // 创建索引 - 请求对象
        CreateIndexRequest request = new CreateIndexRequest("user");
        // 发送请求，获取响应
        CreateIndexResponse response = esClient.indices().create(request, RequestOptions.DEFAULT);
        boolean acknowledged = response.isAcknowledged();
        // 响应状态
        System.out.println("操作状态 = " + acknowledged);

        //关闭es客户端
        esClient.close();
    }

    @Test
    public void testESIndexQuery() throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 查询索引 - 请求对象
        GetIndexRequest request = new GetIndexRequest("user");
        // 发送请求，获取响应
        GetIndexResponse response = esClient.indices().get(request, RequestOptions.DEFAULT);
        System.out.println("aliases:"+response.getAliases());
        System.out.println("mappings:"+response.getMappings());
        System.out.println("settings:"+response.getSettings());

        //关闭es客户端
        esClient.close();
    }



    @Test
    public void testESIndexDelete() throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 查询索引 - 请求对象
        DeleteIndexRequest request = new DeleteIndexRequest("user");
        // 发送请求，获取响应
        AcknowledgedResponse acknowledgedResponse = esClient.indices().delete(request, RequestOptions.DEFAULT);
        // 响应状态
        System.out.println("操作状态 = " + acknowledgedResponse.isAcknowledged());

        //关闭es客户端
        esClient.close();
    }


    @Test
    public void testESDocInsert() throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 新增文档 - 请求对象
        IndexRequest indexRequest = new IndexRequest();
        // 设置索引及唯一性标识
        indexRequest.index("user").id("1001");
        // 创建数据对象
        User user = new User();
        user.setName("zhangsan");
        user.setAge(30);
        user.setSex("男");
        // 添加文档数据，数据格式为 JSON 格式
        String userJson = JSON.toJSONString(user);
        indexRequest.source(userJson, XContentType.JSON);
        // 客户端发送请求，获取响应对象
        IndexResponse indexResponse = esClient.index(indexRequest, RequestOptions.DEFAULT);

        //3.打印结果信息
        System.out.println("_index:" + indexResponse.getIndex());
        System.out.println("_id:" + indexResponse.getId());
        System.out.println("_result:" + indexResponse.getResult());

        //关闭es客户端
        esClient.close();
    }

    @Test
    public void testESDocUpdate() throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        // 修改文档 - 请求对象
        UpdateRequest updateRequest = new UpdateRequest();
        // 配置修改参数
        updateRequest.index("user").id("1001");
        // 设置请求体，对数据进行修改
        updateRequest.doc(XContentType.JSON,"sex","女");
        // 客户端发送请求，获取响应对象
        UpdateResponse updateResponse = esClient.update(updateRequest, RequestOptions.DEFAULT);


        System.out.println("_index:" + updateResponse.getIndex());
        System.out.println("_id:" + updateResponse.getId());
        System.out.println("_result:" + updateResponse.getResult());
        //关闭es客户端
        esClient.close();
    }

    @Test
    public void testESDocGet() throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //1.创建请求对象
        GetRequest getRequest = new GetRequest();
        getRequest.index("user").id("1001");
        //2.客户端发送请求，获取响应对象
        GetResponse getResponse = esClient.get(getRequest, RequestOptions.DEFAULT);
        //3.打印结果信息
        System.out.println("_index:" + getResponse.getIndex());
        System.out.println("_type:" + getResponse.getType());
        System.out.println("_id:" + getResponse.getId());
        System.out.println("source:" + getResponse
                .getSourceAsString());

        //关闭es客户端
        esClient.close();
    }


    @Test
    public void testESDocDelete() throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.index("user").id("1001");

        DeleteResponse deleteResponse = esClient.delete(deleteRequest, RequestOptions.DEFAULT);

        //打印信息
        System.out.println(deleteResponse.toString());

        //关闭es客户端
        esClient.close();

    }


    @Test
    public void testESDocInsertBatch() throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //创建批量新增请求对象
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","张三","sex","女","age","31"));
        bulkRequest.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","李四","sex","男","age","32"));
        bulkRequest.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON,"name","王五","sex","女","age","39"));

        //客户端发送请求，获取响应对象
        BulkResponse bulkResponse = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        //打印结果信息
        System.out.println("took:" + bulkResponse.getTook());
        System.out.println("items:" + bulkResponse.getItems());
        //关闭es客户端
        esClient.close();
    }

    @Test
    public void testESDocDeleteBatch() throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //创建批量删除请求对象
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new DeleteRequest().index("user").id("1002"));
        bulkRequest.add(new DeleteRequest().index("user").id("1003"));
        bulkRequest.add(new DeleteRequest().index("user").id("1004"));

        //客户端发送请求，获取响应对象
        BulkResponse bulkResponse = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        //打印结果信息
        System.out.println("took:" + bulkResponse.getTook());
        System.out.println("items:" + bulkResponse.getItems());
        //关闭es客户端
        esClient.close();
    }

}
