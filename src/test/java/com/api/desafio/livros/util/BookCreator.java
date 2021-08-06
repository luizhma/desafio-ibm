package com.api.desafio.livros.util;

import com.api.desafio.livros.model.Author;
import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.model.Category;

public class BookCreator {
    public static Book createBookToBeSaved(){
        Category category = CategoryCreator.createCategoryToBeSaved();
        return Book.builder()
                .nome("A Menina que Roubava Livros")
                .descricao("Descricao Teste")
                .author(Author.builder().build())
                .category(category)
                .classificacao(5.0)
                .sbn("SBN do Livro")
                .estoque(3)
                .build();
    }

    public static Book createValidBook(){
        return Book.builder()
                .nome("A Menina que Roubava Livros")
                .descricao("Descricao Teste")
                .author(Author.builder().build())
                .category(CategoryCreator.createCategoryToBeSaved())
                .classificacao(5.0)
                .sbn("SBN do Livro")
                .estoque(3)
                .id(1L)
                .build();
    }

    public static Book createValidUpdatedBook(){
        return Book.builder()
                .nome("E o vendo Levou")
                .descricao("Descricao Teste")
                .author(Author.builder().build())
                .category(Category.builder().build())
                .classificacao(5.0)
                .sbn("SBN do Livro")
                .estoque(3)
                .id(1L)
                .build();
    }
}
