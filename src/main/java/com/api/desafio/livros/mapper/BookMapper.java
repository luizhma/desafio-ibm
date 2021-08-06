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
    @Mapping(source = "author", target = "author")
    BookResponseDTO bookResponseDTOToBook(Book book);

    @Mapping(source = "category_id", target = "category.id")
    @Mapping(source = "author_id", target = "author.id")
    Book bookToBookRequestDTO(BookRequestDTO bookRequestDTO);

    @Mapping(source = "category", target = "category")
    @Mapping(source = "author", target = "author")
    List<BookResponseDTO> booksResponseDTOToBooks(List<Book> book);

}
