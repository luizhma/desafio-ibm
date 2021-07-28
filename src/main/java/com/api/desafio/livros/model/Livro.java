package com.api.desafio.livros.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Livro implements Serializable {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String sbn;
    private String nome;
    private String descricao;
    private Integer estoque;
    private Integer classificacao;

    /*
    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Categoria categoria;
    */
}
