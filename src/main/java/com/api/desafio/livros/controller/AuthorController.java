package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.AuthorDTO;
import com.api.desafio.livros.mapper.AuthorMapper;
import com.api.desafio.livros.model.Author;
import com.api.desafio.livros.service.AuthorService;
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
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorMapper authorMapper;

    @GetMapping ("/author")
    @ApiOperation(value = "Retorna uma lista de autor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de autor"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public List<AuthorDTO> list() {
        return authorMapper.dtoToEntity(authorService.list());
    }

    @GetMapping(path = "/{id}")
    public AuthorDTO findById(@PathVariable Long id){
        return authorMapper.dtoToEntity(authorService.findById(id));
    }


    @PostMapping("/author")
    public Author insert(@Valid @RequestBody AuthorDTO authorDTO) {
        return authorService.save(authorMapper.entityToDTO(authorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Author> update(@Valid @RequestBody AuthorDTO authorDTO) {
        authorService.update(authorMapper.entityToDTO(authorDTO));
        return ResponseEntity.noContent().build();
    }
}
