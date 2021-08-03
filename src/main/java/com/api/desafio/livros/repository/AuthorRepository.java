package com.api.desafio.livros.repository;


import com.api.desafio.livros.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> , CrudRepository<Author, Long> {

    List<Author> findByNameContainingIgnoreCase(String name);

    List<Author> findByNameIgnoreCaseContainingOrBiographyIgnoreCaseContaining(String name, String biography);

}
