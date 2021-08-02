package com.api.desafio.livros.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {
    private Long id;
    private String name;
    private String city;
    private Integer age;
}
