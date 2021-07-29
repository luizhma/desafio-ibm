package com.api.desafio.livros.mapper;

import com.api.desafio.livros.DTO.CategoryDTO;
import com.api.desafio.livros.model.Category;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper( componentModel = "spring")
public class CategoryMapper{
    public static Category dtoToEntity(CategoryDTO categoryDTO) {
        if (Objects.isNull(categoryDTO))
            return new Category();

        return Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
    }

    public static CategoryDTO entityToDto(Category entity){
        if (Objects.isNull(entity))
            return new CategoryDTO();

            return CategoryDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .build();
    }
}
