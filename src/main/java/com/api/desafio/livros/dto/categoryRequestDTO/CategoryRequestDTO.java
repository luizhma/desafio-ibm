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

    @ApiModelProperty(value = "Campo obrigatório somente na atualização", required = true)
    private Long id;

    @ApiModelProperty(value = "Nome da Categoria. Deve ter entre 3 e 100 caracteres", required = true)
    private String name;

}
