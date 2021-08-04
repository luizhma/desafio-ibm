package com.api.desafio.livros.mapper;

import com.api.desafio.livros.dto.authorReponseDTO.AuthorResponseDTO;
import com.api.desafio.livros.dto.authorResquestDTO.AuthorRequestDTO;
import com.api.desafio.livros.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorResponseDTO authorResponseDTOToEntity(Author author);

    Author authorToDTO(AuthorResponseDTO authorResponseDTO);

    Author authorToAuthorRequestDTO(AuthorRequestDTO authorRequestDTO);

    AuthorRequestDTO authorRequestDTOToAuthor(Author author);

    @Mapping(target = "id", ignore = true)
    List<AuthorRequestDTO> authorRequestDTOToAuthor(List<Author> author);

}
