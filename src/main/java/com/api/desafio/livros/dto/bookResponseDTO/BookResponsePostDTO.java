package com.api.desafio.livros.dto.bookResponseDTO;

import com.api.desafio.livros.dto.categoryResponseDTO.CategoryResponseToBookDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponsePostDTO {
    @ApiModelProperty(value = "Identificador universal do livro")
    private String sbn;
    @ApiModelProperty(value = "Nome do livro. Deve ter no minimo x caracteres ", required = true)
    private String nome;
    @ApiModelProperty(value = "Descrição do livro")
    private String descricao;
    @ApiModelProperty(value = "Estoque do livro")
    private Integer estoque;
    @ApiModelProperty(value = "Classificação do livro")
    private Double classificacao;
    @ApiModelProperty(value = "Categoria do livro")
    private CategoryResponseToBookDTO category;
}
