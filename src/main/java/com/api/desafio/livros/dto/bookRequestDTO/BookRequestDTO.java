package com.api.desafio.livros.dto.bookRequestDTO;

import com.api.desafio.livros.dto.AuthorDTO;
import com.api.desafio.livros.dto.CategoryDTO;
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
    private CategoryDTO category;
    private AuthorDTO author;
}
