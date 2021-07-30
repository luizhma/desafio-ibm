package com.api.desafio.livros.repository;

import com.api.desafio.livros.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long> {

}
