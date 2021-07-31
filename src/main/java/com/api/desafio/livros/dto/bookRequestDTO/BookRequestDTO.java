package com.api.desafio.livros.dto.bookRequestDTO;

import com.api.desafio.livros.dto.AuthorDTO;
import com.api.desafio.livros.dto.categoryResponseDTO.CategoryResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {
    private String sbn;
    private String nome;
    private String descricao;
    private Integer estoque;
    private Double classificacao;
    private CategoryResponseDTO category;
    private AuthorDTO author;
}
