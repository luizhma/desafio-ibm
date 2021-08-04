package com.api.desafio.livros.repository;


import com.api.desafio.livros.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> , CrudRepository<Author, Long> {

}
