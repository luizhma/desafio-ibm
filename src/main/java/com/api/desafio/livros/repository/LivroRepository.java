package com.api.desafio.livros.repository;

import com.api.desafio.livros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository <Livro, Long> {

}
