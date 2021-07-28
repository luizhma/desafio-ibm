package com.api.desafio.livros.dto.responseDto;

import com.api.desafio.livros.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponseDto {
        private String sbn;
        private String nome;
        private String descricao;
        private Integer estoque;
        private Double classificacao;

    public LivroResponseDto(Livro livro){
        this.sbn = livro.getSbn();
        this.nome = livro.getNome();
        this.descricao = livro.getDescricao();
        this.estoque = livro.getEstoque();
        this.classificacao = livro.getClassificacao();
    }

}


