package com.api.desafio.livros.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {

    private Long id;
    private String name;
    private Integer age;

}
