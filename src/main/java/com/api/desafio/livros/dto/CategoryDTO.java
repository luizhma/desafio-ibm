package com.api.desafio.livros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;
    @NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 3, max = 100 , message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String name;

    private List<BookDTO> books;
}
