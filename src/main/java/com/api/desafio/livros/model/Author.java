package com.api.desafio.livros.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "author")
@Table(name = "tb_author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Length(max = 50, message = "Max 50 caracteres")
    @NotEmpty(message = "Campo nome é obrigatório")
    @Column
    private String name;

    @Length(max = 50, message = "Max 50 caracteres")
    @NotEmpty(message = "Campo nacionalidade é obrigatório")
    @Column
    private String nationality;

    @Length(max = 250, message = "Max 250 caracteres")
    @NotEmpty(message = "Campo Briografia")
    private String biography;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate birthdate;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;

}
