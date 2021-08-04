package com.api.desafio.livros.dto.authorReponseDTO;

import com.api.desafio.livros.model.Book;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDTO implements Serializable {

    @ApiModelProperty(value = "ID de Autor")
    private Long id;
    @ApiModelProperty(value = "Nome do Autor")
    private String name;
    @ApiModelProperty(value = "Nacionalidade do Autor", required = true)
    private String nationality;
    @ApiModelProperty(value = "Briografia do Autor")
    private String biography;
    @ApiModelProperty(value = "Data de nascimento do Autor")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    @ApiModelProperty(value = "todos os livros deste Autor")
    private Book book;
}

