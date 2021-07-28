package com.api.desafio.livros.controller;

import com.api.desafio.livros.model.Livro;
import com.api.desafio.livros.dto.requestDto.LivroRequestDto;
import com.api.desafio.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping("/livros")
    public List<Livro> getLivros(){
        return livroService.getLivros();
    }

    @GetMapping("/livro/{id}")
    public Optional<Livro> getLivro(@PathVariable Long id){
        return livroService.getLivro(id);
    }

    @PostMapping("/livro")
    public void saveLivro(@RequestBody LivroRequestDto livroRequestDto){
        livroService.saveLivro(livroRequestDto);
    }

    @PutMapping("/livro")
    public Livro putLivro(@RequestBody Livro livro){
        return livroService.putLivro(livro);
    }

    @DeleteMapping("/livro/{id}")
    public void deleteLivro(@PathVariable Long id){
        livroService.deleteLivro(id);
    }


}
