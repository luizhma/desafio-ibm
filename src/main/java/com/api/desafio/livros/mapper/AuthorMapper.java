package com.api.desafio.livros.mapper;

import com.api.desafio.livros.dto.AuthorDTO;
import com.api.desafio.livros.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO dtoToEntity(Author author);

    List<AuthorDTO> dtoToEntity(List<Author> author);

    Author entityToDTO(AuthorDTO authorDTO);

}
