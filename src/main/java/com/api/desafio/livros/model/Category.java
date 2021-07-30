package com.api.desafio.livros.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Data
@Builder
@Entity
@Table(name = "tb_category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long id;
    @Column(name = "st_name")
    private String name;

<<<<<<< HEAD
    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();
=======
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "category")
    private List<Livro> livros;
>>>>>>> ed793a4623b847e27e386c25bb2aca7755f3cfdd

}
