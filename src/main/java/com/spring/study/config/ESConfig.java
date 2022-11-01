package com.spring.study.config;

import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @author Qi
 * @description
 * @date 2022/8/18 7:36
 */
@ConfigurationProperties(prefix = "elasticsearch")
@Configuration
@Data
public class ESConfig extends AbstractElasticsearchConfiguration {
    private String host;
    private Integer port;
    @Override
    public RestHighLevelClient elasticsearchClient() {
        RestHighLevelClient highLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port)));
        return highLevelClient;
    }
}
