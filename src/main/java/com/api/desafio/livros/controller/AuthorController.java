package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.AuthorDTO;
import com.api.desafio.livros.mapper.AuthorMapper;
import com.api.desafio.livros.model.Author;
import com.api.desafio.livros.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorMapper authorMapper;

    @GetMapping
    public List<AuthorDTO> list() {
        return authorMapper.dtoToEntity(authorService.list());
    }

    @GetMapping(path = "/{id}")
    public AuthorDTO findById(@PathVariable Long id){
        return authorMapper.dtoToEntity(authorService.findById(id));
    }

    @PostMapping("/")
    public Author save(@Valid @RequestBody AuthorDTO authorDTO) {
        return authorService.save(authorMapper.entityToDTO(authorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/")
    public ResponseEntity<Author> update(@Valid @RequestBody AuthorDTO authorDTO) {
        authorService.update(authorMapper.entityToDTO(authorDTO));
        return ResponseEntity.noContent().build();
    }
}
