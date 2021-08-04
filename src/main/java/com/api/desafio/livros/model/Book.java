package com.api.desafio.livros.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    @NotNull(message = "Campo SBN é obrigatório!")
    private String sbn;
    @NotNull(message = "Campo NOME é requerido")
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
