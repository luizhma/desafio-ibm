package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Customers;
import com.api.desafio.livros.model.CustomersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private WebClient webClient;

    public List<Customers> obterCustomers(){
        Mono <CustomersList> customersListMono = this.webClient
                .method(HttpMethod.GET)
                .uri("/v3/37946fab-4b1b-447c-8d63-7d8e9ccb57e6")
                .retrieve()
                .bodyToMono(CustomersList.class);

        CustomersList customersList = customersListMono.block();

        List<Customers> allCustomers = customersList.getCustomers();
        List<Customers> listCustomersPlus65 = new ArrayList<>();
        for (Customers customers : allCustomers) {
            if(customers.getAge() <= 65){
                listCustomersPlus65.add(customers);
            }
        }

        return listCustomersPlus65;
    }
}
