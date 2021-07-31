package com.api.desafio.livros.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @Column
    protected Long id;

    @Column(name = "name", length = 50 , nullable = false)
    private String name;

    @Column(length = 60, nullable = false, unique = false)
    private String nationality;

    @Column(length = 60, nullable = false, unique = false)
    private String biography;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;

 /*   @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "author")
    private List<Book> books;*/

}
