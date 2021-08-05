package com.api.desafio.livros.util;

import com.api.desafio.livros.dto.categoryRequestDTO.CategoryRequestDTO;

public class CategoryRequestDTOCreator {


    public static CategoryRequestDTO createCategoryRequestToBeSaved() {
        return  CategoryRequestDTO.builder()
                .id(null)
                .name(CategoryCreator.createCategoryToBeSaved().getName())
                .build();
    }

    public static CategoryRequestDTO createCategoryRequestToBeValidSaved() {
        return  CategoryRequestDTO.builder()
                .id(1L)
                .name(CategoryCreator.createCategoryToBeSaved().getName())
                .build();
    }

}
