package com.api.desafio.livros.dto.categoryResponseDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseToBookDTO implements Serializable {
    @ApiModelProperty(value = "ID da Categoria")
    private Long id;
}
