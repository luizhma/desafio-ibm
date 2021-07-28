package com.api.desafio.livros.dto.requestDto;

import com.api.desafio.livros.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroRequestDto {
    private Long id;
    private String sbn;
    private String nome;
    private String descricao;
    private Integer estoque;
    private Double classificacao;


    public Livro buildLivro(){
        Livro livro = new Livro()
                .setId(this.id)
                .setSbn(this.sbn)
                .setNome(this.nome)
                .setDescricao(this.descricao)
                .setEstoque(this.estoque)
                .setClassificacao(this.classificacao);
        return livro;
    }

}
