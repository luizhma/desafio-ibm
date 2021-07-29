package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void instanciaBaseDeDados() {

        Category cat1 = new Category(null, "informática");
        Category cat2 = new Category(null, "Ficção Científica");
        Category cat3 = new Category(null, "Biografias");
        Category cat4 = new Category(null, "Gramática");
        Category cat5 = new Category(null, "Universitários e Acadêmicos");

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

    }

}
