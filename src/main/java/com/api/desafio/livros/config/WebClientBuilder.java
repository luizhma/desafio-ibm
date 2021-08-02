package com.api.desafio.livros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientBuilder {

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder
                .baseUrl("https://run.mocky.io")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
