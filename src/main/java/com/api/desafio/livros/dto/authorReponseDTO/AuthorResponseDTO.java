package com.api.desafio.livros.dto.authorReponseDTO;

import com.api.desafio.livros.model.Book;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDTO implements Serializable {

    @ApiModelProperty(value = "ID de Autor")
    private Long id;

    @ApiModelProperty(value = "Nome do Autor  Max 50 caracteres", required = true)
    private String name;

    @ApiModelProperty(value = "Nacionalidade do Autor  Max 50 caracteres")
    private String nationality;

    @ApiModelProperty(value = "Briografia do Autor Max 250 caracteres")
    private String biography;

    @ApiModelProperty(value = "Data de nascimento do Autor")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @ApiModelProperty(value = "todos os livros deste Autor")
    private List<Book> books;
}

