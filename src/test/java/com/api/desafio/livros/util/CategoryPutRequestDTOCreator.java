package com.api.desafio.livros.util;

import com.api.desafio.livros.dto.categoryRequestDTO.CategoryRequestDTO;

public class CategoryPutRequestDTOCreator {


    public static CategoryRequestDTO createCategoryPutRequestToBeSaved() {
        return  CategoryRequestDTO.builder()
                .id(CategoryCreator.createValidUpdatedCategory().getId())
                .name(CategoryCreator.createValidUpdatedCategory().getName())
                .build();
    }

}
