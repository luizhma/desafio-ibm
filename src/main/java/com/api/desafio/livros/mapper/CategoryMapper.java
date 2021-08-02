package com.api.desafio.livros.mapper;

import com.api.desafio.livros.dto.categoryRequestDTO.CategoryRequestDTO;
import com.api.desafio.livros.dto.categoryResponseDTO.CategoryResponseDTO;
import com.api.desafio.livros.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryResponseDTO categoryResponseDTOToEntity(Category category);

    Category categoryToDTO(CategoryResponseDTO categoryResponseDTO);

    Category categoryToCategoryRequestDTO(CategoryRequestDTO categoryRequestDTO);

    CategoryRequestDTO categoryRequestDTOToCategory(Category category);

    @Mapping(target = "id", ignore = true)
    List<CategoryRequestDTO> categoriesRequestDTOToCategories(List<Category> category);

}
