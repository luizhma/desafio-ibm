package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.BookDTO;
import com.api.desafio.livros.mapper.BookMapper;
import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.service.BookService;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

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
    @ApiOperation(value = "Retorna uma lista de livros")
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "Retorna uma lista de livros"),
    	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
    	    @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    	})    
    public List<BookDTO> list(){
        return bookMapper.livrosDTOToLivros(bookService.findAll());
    }

    @GetMapping("/book/{id}")
    public BookDTO findById(@PathVariable Long id){
        return bookMapper.livroDTOToLivro(bookService.findById(id));
    }

    @PostMapping("/book")
    @ApiOperation(value = "Adiciona um livro")
    @ApiResponses(value = {
    	    @ApiResponse(code = 201, message = "Livro Cadastrado"),
    	    @ApiResponse(code = 400, message = "Algum problema na requisição"),
    	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
    	    @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    	})        
    public Book insert(@Valid @RequestBody BookDTO book){
        return bookService.save(bookMapper.livroToDTO(book));
    }

    @PutMapping("/book")
    public ResponseEntity<Book> update(@Valid @RequestBody BookDTO bookDTO){
        bookService.update(bookMapper.livroToDTO(bookDTO));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
       BookDTO bookDTO = bookMapper.livroDTOToLivro(bookService.findById(id));
       bookService.delete(bookDTO.getId());
       return ResponseEntity.noContent().build();
    }


}
