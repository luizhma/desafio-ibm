package com.api.desafio.livros.mapper;

import com.api.desafio.livros.dto.CategoryDTO;
import com.api.desafio.livros.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

   public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    public abstract CategoryDTO dtoToEntity(Category category);

    public abstract List<CategoryDTO> dtosToEntity(List<Category> category);

    public abstract Category entityToDto(CategoryDTO categoryDTO);

}
