package com.api.desafio.livros.dto.bookRequestDTO;

import com.api.desafio.livros.dto.AuthorDTO;
import com.api.desafio.livros.dto.CategoryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {
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
    @ApiModelProperty(value = "Categoria do livro")
    private CategoryDTO category;
    @ApiModelProperty(value = "Autor do livro")
    private AuthorDTO author;
}
