package com.api.desafio.livros.mapper;

import com.api.desafio.livros.dto.CategoryDTO;
import com.api.desafio.livros.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO dtoToEntity(Category category);

    List<CategoryDTO> dtosToEntity(List<Category> category);

    Category entityToDto(CategoryDTO categoryDTO);

}
