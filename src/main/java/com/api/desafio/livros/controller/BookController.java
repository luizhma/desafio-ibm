package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.BookDTO;
import com.api.desafio.livros.mapper.BookMapper;
import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookMapper bookMapper;


    @GetMapping
    public List<BookDTO> list(){
        return bookMapper.livrosDTOToLivros(bookService.findAll());
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id){
        return bookMapper.livroDTOToLivro(bookService.findById(id));
    }

    @PostMapping("/insert")
    public Book insert(@RequestBody BookDTO bookDTO){
        return bookService.save(bookMapper.livroToDTO(bookDTO));
    }

    @PutMapping("/update")
    public Book update(@RequestBody BookDTO bookDTO){
        return bookService.update(bookMapper.livroToDTO(bookDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
       BookDTO bookDTO = bookMapper.livroDTOToLivro(bookService.findById(id));
       bookService.delete(bookDTO.getId());
    }


}
