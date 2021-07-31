package com.api.desafio.livros.dto.bookResponseDTO;

import com.api.desafio.livros.dto.CategoryDTO;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookResponseDTO {
    private Long id;
    private String sbn;
    private String nome;
    private String descricao;
    private Integer estoque;
    private Double classificacao;
    private CategoryDTO category;
}
