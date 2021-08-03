package com.api.desafio.livros.mapper;

import com.api.desafio.livros.dto.bookRequestDTO.BookRequestDTO;
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
    BookResponseDTO bookResponseDTOToBook(Book book);

    @Mapping(source = "category", target = "category")
    Book bookToBookRequestDTO(BookRequestDTO bookRequestDTO);

    /*  @Mapping(source = "author", target = "author") */
    @Mapping(source = "category", target = "category")
    List<BookResponseDTO> booksResponseDTOToBooks(List<Book> book);

}
