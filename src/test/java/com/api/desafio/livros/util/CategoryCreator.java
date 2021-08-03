package com.api.desafio.livros.util;

import com.api.desafio.livros.model.Category;

public class CategoryCreator {

    public static Category createCategoryToBeSaved() {
        return Category.builder()
                .name("Informática")
                .build();
    }

    public static Category createCategoryValidCategory() {
        return Category.builder()
                .name("Informática")
                .id(1L)
                .build();
    }

    public static Category createValidUpdatedCategory() {
        return Category.builder()
                .name("Update")
                .id(1L)
                .build();
    }
}
