package com.api.desafio.livros.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "tb_book")
@Accessors(chain = true)
@Data
public class Book implements Serializable {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotEmpty (message = "Campo SBN é obrigatório!")
    private String sbn;
    @NotEmpty(message = "Campo NOME é requerido")
    private String nome;
    @Length (max = 150, message = "Max 150 caracteres")
    @NotEmpty (message = "Campo Descrição é obrigatório!")
    private String descricao;
    @NotNull (message = "Campo Estoque é obrigatório!")
    private Integer estoque;
    @NotNull (message = "Campo Classificação é obrigatório!")
    private Double classificacao;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author")
    private Author author;

}
