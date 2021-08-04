package com.api.desafio.livros.dto.authorResquestDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
public class AuthorRequestDTO implements Serializable {

    @ApiModelProperty(value = "ID de Autor")
    private Long id;
    @ApiModelProperty(value = "Nome do Autor  Max 50 caracteres", required = true)
    private String name;
    @ApiModelProperty(value = "Nacionalidade do Autor Max 50 caracteres", required = true)
    private String nationality;
    @ApiModelProperty(value = "Biografia do Autor Max 250 caracteres")
    private String biography;
    @ApiModelProperty(value = "Data de nascimento de Autor", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
}
