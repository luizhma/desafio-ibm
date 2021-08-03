package com.api.desafio.livros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private Long id;
    private String name;
    private String nationality;
    private String biography;
    private LocalDate birthdate;


}
