package com.api.desafio.livros.util;


import com.api.desafio.livros.model.Author;
import com.api.desafio.livros.model.Category;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AuthorCreator {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static LocalDate dt1 = LocalDate.parse(("01/01/1978"), formatter);

    public static Author createAuthorToBeSaved() {
        return Author.builder()
                .id(1l)
                .name("Nome do Author")
                .nationality("Nacionalidade do Author")
                .biography("Biografia Author")
                .birthdate(dt1)
                .build();
    }

    public static Author createValidUpdatedAuthor() {
        return Author.builder()
                .id(1L)
                .name("Nome do Author Alterado")
                .nationality("Nacionalidade do Author alterada")
                .biography("Biografia Author alterad")
                .birthdate(dt1)
                .build();
    }
}
