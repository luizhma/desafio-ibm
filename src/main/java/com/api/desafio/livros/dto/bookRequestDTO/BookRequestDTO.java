package com.api.desafio.livros.dto.bookRequestDTO;

import com.api.desafio.livros.service.validation.BookInsert;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BookInsert
public class BookRequestDTO implements Serializable {
    @ApiModelProperty(value = "SBN do livro")
    private String sbn;
    @ApiModelProperty(value = "Nome do livro")
    private String nome;
    @ApiModelProperty(value = "Descricao do livro")
    private String descricao;
    @ApiModelProperty(value = "Estoque do livro")
    private Integer estoque;
    @ApiModelProperty(value = "Classificacao do livro")
    private Double classificacao;
    @ApiModelProperty(value = "Categoria do livro", required = true)
    private CategoryIdDTO category;
}
