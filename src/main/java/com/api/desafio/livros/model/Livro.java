package com.api.desafio.livros.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class Livro implements Serializable {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String sbn;
    private String nome;
    private String descricao;
    private Integer estoque;
    private Double classificacao;

    /*
    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Categoria categoria;
    */
}
