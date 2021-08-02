package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.AuthorDTO;
import com.api.desafio.livros.mapper.AuthorMapper;
import com.api.desafio.livros.model.Author;
import com.api.desafio.livros.service.AuthorService;
import com.api.desafio.livros.service.exceptions.ServerException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @Autowired
    private AuthorMapper authorMapper;

    @GetMapping("/author")
    @ApiOperation(value = "Lista todos os autores")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 200, message = "Retorna uma lista de autores"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public List<AuthorDTO> list()
    {
        return authorMapper.dtoToEntity(authorService.list());
    }

    @GetMapping("/author/{id}")
    @ApiOperation(value = "Buscar Autor por id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 404, message = "Autor não existe"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public AuthorDTO findById(@PathVariable Long id) {
        return authorMapper.dtoToEntity(authorService.findById(id));

    }


    @PostMapping("/author")
    @ApiOperation(value = "Adiciona um Author")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Autor Cadastrado"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public ResponseEntity<Author> insert(@Valid @RequestBody AuthorDTO authorDTO) {
        Author newAtuhor = authorService.save(authorMapper.entityToDTO(authorDTO));
        if (newAtuhor == null) {
            throw new ServerException();
        } else {
            return new ResponseEntity<>(authorService.save(authorMapper.entityToDTO(authorDTO)), HttpStatus.CREATED);
        }
    }


    @DeleteMapping("/author/{id}")
    @ApiOperation(value = "Deleta um autor")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Solicitação bem sucedida"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Autor não existe"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/author")
    @ApiOperation(value = "Atualiza um autor")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Solicitação bem sucedida"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Autor não existe"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public ResponseEntity<Author> update(@Valid @RequestBody AuthorDTO newAuthor) {
        Author author = authorService.update(authorMapper.entityToDTO(newAuthor));
        if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.CREATED);
        } else {
            throw new ServerException();
        }
    }
}


