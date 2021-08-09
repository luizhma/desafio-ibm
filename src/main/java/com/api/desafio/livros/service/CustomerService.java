package com.api.desafio.livros.service;

import com.api.desafio.livros.dto.CustomerDTO;
import com.api.desafio.livros.dto.CustomerListDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Value("${customersUrl}")
    private String customersUrl;

    public List<CustomerDTO> customers() {
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(customersUrl);

        ResponseEntity<CustomerListDTO> customersDTOResponseEntity = new RestTemplate().exchange(uri.toUriString(), HttpMethod.GET, null, CustomerListDTO.class);


      List<CustomerDTO> customerListDTO = customersDTOResponseEntity.getBody().getCustomers().stream()
              .filter(customerDTO -> customerDTO.getAge() < 65)
              .collect(Collectors.toList());
        return customerListDTO;
    }
}