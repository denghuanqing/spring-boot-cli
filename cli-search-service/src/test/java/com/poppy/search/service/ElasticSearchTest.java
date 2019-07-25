package com.poppy.search.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

@SpringBootTest
@Slf4j
public class ElasticSearchTest {
    RestHighLevelClient client = null;
    String INDEX = "idx_app_event_181229";
    String TYPE = "ui_event";

    @Before
    public void setupMockMvc() {
        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("10.72.8.87", 9200, "http"),
                        new HttpHost("10.72.8.88", 9200, "http"),
                        new HttpHost("10.72.8.89", 9200, "http")));

    }

    @Test
    public void seaech() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        log.info("查询结果：{}", search);
        Assert.assertThat(0L, lessThan(search.getHits().totalHits));

    }

    @Test
    public void seaech2() throws IOException {
        SearchRequest searchRequest = new SearchRequest();

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("user", "kimchy"));
        sourceBuilder.from(0);
        sourceBuilder.size(5);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        searchRequest.source(sourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        log.info("查询结果：{}", JSON.toJSONString(search, SerializerFeature.PrettyFormat));

        Assert.assertThat(0L, lessThanOrEqualTo(search.getHits().totalHits));
    }
}
