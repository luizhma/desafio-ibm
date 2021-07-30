package com.api.desafio.livros.mapper;

import com.api.desafio.livros.dto.BookDTO;
import com.api.desafio.livros.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO livroDTOToLivro(Book book);

    List<BookDTO> livrosDTOToLivros(List<Book> book);

    Book livroToDTO(BookDTO bookDTO);
}
