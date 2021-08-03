package com.api.desafio.livros.dto.authorReponseDTO;

import com.api.desafio.livros.dto.AuthorDTO;
import com.api.desafio.livros.dto.categoryResponseDTO.CategoryResponseDTO;
import com.api.desafio.livros.model.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponsePostDTO {

    @ApiModelProperty(value = "Nome do Autor")
    private String name;

    @ApiModelProperty(value = "Nacionalidade do Autor", required = true)
    private String nationality;

    @ApiModelProperty(value = "Briografia do Autor")
    private String biography;

    @ApiModelProperty(value = "Data de nascimento do Autor")
    private LocalDate birthdate;

    @ApiModelProperty(value = "todos os livros deste Autor")
    private Book book;


}

