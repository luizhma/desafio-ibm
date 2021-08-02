package com.api.desafio.livros.repository;


import com.api.desafio.livros.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> , CrudRepository<Author, Long> {

    @Query("select a from author a where a.name = :name")
    List<Author> findByNameContaining(@Param("name") String name);

}
