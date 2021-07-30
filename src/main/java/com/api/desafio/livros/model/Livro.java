package com.api.desafio.livros.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author")
    private Author author;


}
