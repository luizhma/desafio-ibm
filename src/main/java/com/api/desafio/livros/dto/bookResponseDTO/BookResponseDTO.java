package com.api.desafio.livros.dto.bookResponseDTO;

import com.api.desafio.livros.dto.bookRequestDTO.CategoryIdDTO;
import com.api.desafio.livros.dto.categoryRequestDTO.CategoryRequestDTO;
import com.api.desafio.livros.dto.categoryResponseDTO.CategoryResponseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO implements Serializable {
    @ApiModelProperty(value = "Campo deve ser preenchido somente na atualização", required = true)
    private Long id;
    @ApiModelProperty(value = "Campo deve ser preenchido somente na inserção", required = true)
    private String sbn;
    @ApiModelProperty(value = "Campo Nome deve ter entre 3 e 100 caracteres", required = true)
    private String nome;
    @ApiModelProperty(value = "Campo Descricao deve ter no maximo 100 caracteres", required = true)
    private String descricao;
    @ApiModelProperty(value = "Campo Estoque não deve ser nulo", required = true)
    private Integer estoque;
    @ApiModelProperty(value = "Campo Classificacao deve ter o valor de 0 a 5", required = true)
    private Double classificacao;
    @ApiModelProperty(value = "Campo categoria ID é obrigatório", required = true)
    private CategoryRequestDTO category;
}
