package com.api.desafio.livros.model;

import lombok.AllArgsConstructor;
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
@Table (name = "tb_book")
@Accessors(chain = true)
@Data
public class Book implements Serializable {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotEmpty (message = "Campo SBN é obrigatório!")
    private String sbn;
    @NotEmpty (message = "Campo Nome é obrigatório!")
    @Length (min = 3, max = 100 , message = "O NOME deve ter entre 3 e 100 caracteres")
    private String nome;
    @Length (max = 150, message = "Max 150 caracteres")
    @NotEmpty (message = "Campo Descrição é obrigatório!")
    private String descricao;
    @NotNull (message = "Campo Estoque é obrigatório!")
    private Integer estoque;
    @NotNull (message = "Campo Classificação é obrigatório!")
    private Double classificacao;

    /*
    @ManyToOne
    private Autor autor;

*/

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
