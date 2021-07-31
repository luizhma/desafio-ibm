package com.api.desafio.livros.dto.categoryRequestDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDTO implements Serializable {

    @ApiModelProperty(value = "Nome da Categoria")
    private String name;

}
