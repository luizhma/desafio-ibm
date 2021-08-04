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
@Data
public class Book implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Length (min = 1, max = 100, message = "O campo SNB deve ter entre 1 e 100 caracteres")
    @NotEmpty(message = "Campo SBN é obrigatório")
    private String sbn;

    @Length (min = 3, max = 100, message = "O campo Nome deve ter entre 3 e 100 caracteres")
    @NotEmpty(message = "Campo NOME é obrigatorio")
    private String nome;

    @Length (max = 150, message = "O campo Descricao deve ter no maximo 100 caracteres")
    @NotEmpty (message = "Campo Descrição é obrigatório!")
    private String descricao;

    @NotNull (message = "O campo Estoque não deve ser nulo")
    private Integer estoque;

    @NotNull (message = "O campo Classificacao deve ter o valor de 0 a 5")
    private Double classificacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category")
    @NotNull (message = "O campo categoria ID é obrigatório!")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author")
    private Author author;

}
