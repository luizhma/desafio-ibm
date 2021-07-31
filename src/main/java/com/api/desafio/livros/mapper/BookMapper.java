package com.api.desafio.livros.mapper;

import com.api.desafio.livros.dto.bookResponseDTO.BookResponseDTO;
import com.api.desafio.livros.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "category", target = "category")
    BookResponseDTO livroDTOToLivro(Book book);

    @Mapping(source = "category", target = "category")
    List<BookResponseDTO> livrosDTOToLivros(List<Book> book);

    @Mapping(source = "category", target = "category")
    Book livroToDTO(BookResponseDTO bookResponseDTO);


}
