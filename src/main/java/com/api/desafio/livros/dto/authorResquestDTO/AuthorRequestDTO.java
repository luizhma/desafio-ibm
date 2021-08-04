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
    @ApiModelProperty(value = "Nome do Autor")
    private String name;
    @ApiModelProperty(value = "Nacionalidade do Autor")
    private String nationality;
    @ApiModelProperty(value = "Biografia do Autor")
    private String biography;
    @ApiModelProperty(value = "Data de nascimento de Autor")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
}
