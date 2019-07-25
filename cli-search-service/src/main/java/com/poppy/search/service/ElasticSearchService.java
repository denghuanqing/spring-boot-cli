package com.poppy.search.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;

import java.io.IOException;

@Slf4j
public class ElasticSearchService {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("10.72.8.87", 9200, "http"),
                        new HttpHost("10.72.8.88", 9200, "http"),
                        new HttpHost("10.72.8.89", 9200, "http")));

        GetRequest getRequest = new GetRequest(
                "idx_app_event_181229",
                "ui_event",
                "1");

        client.getAsync(getRequest, RequestOptions.DEFAULT, new ActionListener<GetResponse>() {
            @Override
            public void onResponse(GetResponse getResponse) {
                log.info("是否匹配到文档：{}", getResponse.isExists());
                String sourceAsString = getResponse.getSourceAsString();
                log.info("查询结果：{}", sourceAsString);
            }

            @Override
            public void onFailure(Exception e) {
                log.error("查询失败：{}", e);
            }
        });

        log.info(" 异步查询中 ...");

//        client.close();
    }
}
