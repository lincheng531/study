package com.lincheng.study.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
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
}
