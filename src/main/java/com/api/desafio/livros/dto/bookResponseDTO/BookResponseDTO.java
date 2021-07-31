package com.api.desafio.livros.dto.bookResponseDTO;

import com.api.desafio.livros.dto.AuthorDTO;
import com.api.desafio.livros.dto.CategoryDTO;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "Objeto que representa um Livro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookResponseDTO {
    private Long id;
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
    private CategoryDTO category;
    @ApiModelProperty(value = "Autor do livro")
    private AuthorDTO author;
}
