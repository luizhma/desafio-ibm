package com.api.desafio.livros.dto.categoryResponseDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDTO implements Serializable {

    @ApiModelProperty(value = "ID da Categoria")
    private Long id;
    @ApiModelProperty(value = "Nome da Categoria. Deve ter entre 3 e 100 caracteres", required = true)
    private String name;

}
