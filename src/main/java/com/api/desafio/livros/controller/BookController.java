package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.bookResponseDTO.BookResponseDTO;
import com.api.desafio.livros.dto.bookRequestDTO.BookRequestDTO;
import com.api.desafio.livros.mapper.BookMapper;
import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookMapper bookMapper;

    @GetMapping ("/books")
    public List<BookRequestDTO> list(){
        return bookMapper.livrosDTOToLivros(bookService.findAll());
    }

    @GetMapping("/book/{id}")
    public BookRequestDTO findById(@PathVariable Long id){
        return bookMapper.livroRequestDTOToLivro(bookService.findById(id));
    }

    @PostMapping("/book")
    public Book insert(@Valid @RequestBody BookResponseDTO bookResponseDTO){
        return bookService.save(bookMapper.livroToDTO(bookResponseDTO));
    }

    @PutMapping("/book")
    public ResponseEntity<Book> update(@Valid @RequestBody BookResponseDTO bookResponseDTO){
        bookService.update(bookMapper.livroToDTO(bookResponseDTO));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
       BookResponseDTO bookResponseDTO = bookMapper.livroDTOToLivro(bookService.findById(id));
       bookService.delete(bookResponseDTO.getId());
       return ResponseEntity.noContent().build();
    }


}
