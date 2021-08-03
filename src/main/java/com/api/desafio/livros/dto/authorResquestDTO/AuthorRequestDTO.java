package com.api.desafio.livros.dto.authorResquestDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;


@Data
public class AuthorRequestDTO {


    @ApiModelProperty(value = "NOME DO AUTOR")
    private String name;

    @ApiModelProperty(value = "NACIONALIDADE DO AUTOR")
    private String nationality;

    @ApiModelProperty(value = "BIOGRAFIA DO AUTOR")
    private String biography;

    @ApiModelProperty(value = "DATA DE NASCIMENTO AUTOR")
    private LocalDate birthdate;

}
