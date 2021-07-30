package com.api.desafio.livros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {
    private Long id;
    private String sbn;
    private String nome;
    private String descricao;
    private Integer estoque;
    private Double classificacao;

}
