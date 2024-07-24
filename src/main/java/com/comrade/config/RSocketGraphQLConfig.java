package com.comrade.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.graphql.client.RSocketGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RSocketGraphQLConfig {

    @Value("${client.tcp}")
    private String tcp;

    @Value("${client.port}")
    private Integer port;

    @Value("${client.route}")
    private String route;

    @Value("${client.base-url}")
    private String baseUrl;

    @Bean
    public RSocketGraphQlClient rSocketGraphQlClient(RSocketGraphQlClient.Builder<?> rsbuilder){
        return rsbuilder.tcp(tcp,port).route(route).build();
    }

    @Bean
    public HttpGraphQlClient httpGraphQlClient(){
        WebClient webClient = WebClient.create(baseUrl);
        return HttpGraphQlClient.builder(webClient).build();
    }
}
