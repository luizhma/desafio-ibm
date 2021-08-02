package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Customer;
import com.api.desafio.livros.model.CustomerList;
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

    public List<Customer> obterCustomers(){
        Mono <CustomerList> customersListMono = this.webClient
                .method(HttpMethod.GET)
                .uri("/v3/37946fab-4b1b-447c-8d63-7d8e9ccb57e6")
                .retrieve()
                .bodyToMono(CustomerList.class);

        CustomerList customerList = customersListMono.block();

        List<Customer> allCustomers = customerList.getCustomers();
        List<Customer> listCustomerPlus65 = new ArrayList<>();
        for (Customer customer : allCustomers) {
            if(customer.getAge() < 65){
                listCustomerPlus65.add(customer);
            }
        }

        return listCustomerPlus65;
    }
}
