package com.comrade.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DgdWebClientConfig {

    @Bean
    public WebClient dgsWebClient(@Value("${client.base-url}") String baseUrl){
        return WebClient.builder().baseUrl(baseUrl).build();
    }
}
