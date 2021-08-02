package com.api.desafio.livros.service;

import com.api.desafio.livros.config.WebClientBuilder;
import com.api.desafio.livros.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CustomerService {

    @Autowired
    private WebClient webClient;

    public Customers obterCustomers(){
        this.webClient
                .method(HttpMethod.GET)
                .uri("/v3/37946fab-4b1b-447c-8d63-7d8e9ccb57e6")
                .retrieve()
                .bodyToMono(Customers.class);
        return null;
    }
}
