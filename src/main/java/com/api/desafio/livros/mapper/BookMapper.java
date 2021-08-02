package com.api.desafio.livros.mapper;

import com.api.desafio.livros.dto.CustomersDTO;
import com.api.desafio.livros.dto.bookRequestDTO.BookRequestDTO;
import com.api.desafio.livros.dto.bookResponseDTO.BookResponseDTO;
import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.model.Customers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    /*@Mapping(source = "author", target = "author") */
    @Mapping(source = "category", target = "category")
    BookResponseDTO livroDTOToLivro(Book book);

    /*  @Mapping(source = "author", target = "author") */
    @Mapping(source = "category", target = "category")
    List<BookRequestDTO> livrosDTOToLivros(List<Book> book);

    /*@Mapping(source = "author", target = "author") */
    @Mapping(source = "category", target = "category")
    Book livroToDTO(BookResponseDTO bookResponseDTO);

    /* @Mapping(source = "author", target = "author") */
    @Mapping(source = "category", target = "category")
    BookRequestDTO livroRequestDTOToLivro(Book book);

    List<CustomersDTO> customersDTOToCustomers(List<Customers> customers);
}
