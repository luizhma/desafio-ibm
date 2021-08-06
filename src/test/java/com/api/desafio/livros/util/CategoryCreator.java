package com.api.desafio.livros.util;

import com.api.desafio.livros.model.Category;

public class CategoryCreator{

    public static Category createCategoryToBeSaved() {
        return Category.builder()
                .id(1L)
                .name("Informática")
                .build();
    }

    public static Category createValidUpdatedCategory() {
        return Category.builder()
                .id(1L)
                .name("Update")
                .build();
    }

}
