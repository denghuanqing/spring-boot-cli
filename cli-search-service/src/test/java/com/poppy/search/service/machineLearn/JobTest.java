package com.poppy.search.service.machineLearn;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.ml.PutJobRequest;
import org.elasticsearch.client.ml.PutJobResponse;
import org.elasticsearch.client.ml.job.config.AnalysisConfig;
import org.elasticsearch.client.ml.job.config.DataDescription;
import org.elasticsearch.client.ml.job.config.Detector;
import org.elasticsearch.client.ml.job.config.Job;
import org.elasticsearch.common.unit.TimeValue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: DENGHUANQING1
 * @create: 2019-01-23 14:50
 **/

@SpringBootTest
@Slf4j
public class JobTest {
    RestHighLevelClient client = null;

    @Before
    public void setupMockMvc() {
        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("10.72.8.87", 9200, "http"),
                        new HttpHost("10.72.8.88", 9200, "http"),
                        new HttpHost("10.72.8.89", 9200, "http")));

    }

    @Test
    public void putJob() throws IOException {
        Detector.Builder detectorBuilder = new Detector.Builder()
                .setFunction("sum")
                .setFieldName("total")
                .setDetectorDescription("Sum of total");

        List<Detector> detectors = Collections.singletonList(detectorBuilder.build());
        AnalysisConfig.Builder analysisConfigBuilder = new AnalysisConfig.Builder(detectors)
                .setBucketSpan(TimeValue.timeValueMinutes(10));


        DataDescription.Builder dataDescriptionBuilder = new DataDescription.Builder()
                .setTimeField("timestamp");

        Job.Builder jobBuilder = new Job.Builder("id_dhq1")
                .setAnalysisConfig(analysisConfigBuilder)
                .setDataDescription(dataDescriptionBuilder)
                .setDescription("Total sum of requests");

        PutJobRequest request = new PutJobRequest(jobBuilder.build());

        PutJobResponse response = client.machineLearning().putJob(request, RequestOptions.DEFAULT);

    }

}
