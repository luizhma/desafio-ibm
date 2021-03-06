package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.bookRequestDTO.BookRequestDTO;
import com.api.desafio.livros.dto.bookResponseDTO.BookResponseDTO;
import com.api.desafio.livros.mapper.BookMapper;
import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Lista todos os livros")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 200, message = "Retorna uma lista de livros"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public List<BookResponseDTO> list(){
        return bookMapper.booksResponseDTOToBooks(bookService.findAll());
    }

    @GetMapping("/book/{id}")
    @ApiOperation(value = "Buscar livro por id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 404, message = "Livro não existe"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public BookResponseDTO findById(@PathVariable Long id){
        return bookMapper.bookResponseDTOToBook(bookService.findById(id));
    }

    @PostMapping("/book")
    @ApiOperation(value = "Adiciona um livro")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Livro Cadastrado"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public Book insert(@Valid @RequestBody BookRequestDTO book){
        return bookService.save(bookMapper.bookToBookRequestDTO(book));
    }

    @PutMapping("/book")
    @ApiOperation(value = "Atualiza um livro")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Solicitação bem sucedida"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "livro não existe"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public ResponseEntity<Book> update(@Valid @RequestBody BookRequestDTO book){
        bookService.update(bookMapper.bookToBookRequestDTO(book));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/book/{id}")
    @ApiOperation(value = "Deleta um livro")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Solicitação bem sucedida"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Livro não existe"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public ResponseEntity<Void> delete(@PathVariable Long id){
       bookService.delete(id);
       return ResponseEntity.noContent().build();
    }

}
