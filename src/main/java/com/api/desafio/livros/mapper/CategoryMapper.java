package com.api.desafio.livros.mapper;

import com.api.desafio.livros.dto.categoryRequestDTO.CategoryRequestDTO;
import com.api.desafio.livros.dto.categoryResponseDTO.CategoryResponseDTO;
import com.api.desafio.livros.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryResponseDTO dtoToEntity(Category category);

    Category entityToDto(CategoryResponseDTO categoryResponseDTO);

    CategoryRequestDTO categoryRequestDTOToCategory(Category category);

    List<CategoryRequestDTO> categoriesRequestDTOToCategories(List<Category> category);

}
