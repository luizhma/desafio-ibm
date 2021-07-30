package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.model.Livro;
import com.api.desafio.livros.repository.CategoryRepository;
import com.api.desafio.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {

        Category cat1 = Category.builder()
                .id(null)
                .name("Informática")
                .build();
        Category cat2 = Category.builder()
                .id(null)
                .name("Ficção Científica")
                .build();
        Category cat3 = Category.builder()
                .id(null)
                .name("Gramática")
                .build();
        Category cat4 = Category.builder()
                .id(null)
                .name("Universitários e Acadêmicos")
                .build();
        Category cat5 = Category.builder()
                .id(null)
                .name("Biografias")
                .build();
        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

        Livro livro1 = new Livro(null, "sbn", "clean code",
                "Habilidades Práticas do Agile Software", 10, 10.0, cat1);
        this.livroRepository.saveAll(Arrays.asList(livro1));




    }

}
