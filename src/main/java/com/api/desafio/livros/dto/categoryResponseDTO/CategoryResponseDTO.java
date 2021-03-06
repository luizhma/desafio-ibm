package com.api.desafio.livros.dto.categoryResponseDTO;

import com.api.desafio.livros.model.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDTO implements Serializable {

    @ApiModelProperty(value = "Campo obrigatório somente na busca por Id", required = true)
    private Long id;
    @ApiModelProperty(value = "Nome da Categoria. Deve ter entre 3 e 100 caracteres", required = true)
    private String name;
    @ApiModelProperty(value = "Lista de livros")
    private List<Book> books;

}
