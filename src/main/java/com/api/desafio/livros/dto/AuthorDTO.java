package com.api.desafio.livros.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    @NotEmpty(message = "Campo NOME é requerido")
    private String name;

    private String nationality;
    private String biography;
    private LocalDate birthDate;
}
