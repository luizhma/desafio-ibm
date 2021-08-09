package com.api.desafio.livros.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CustomerListDTO implements Serializable {

    private List<CustomerDTO> customers;

}
