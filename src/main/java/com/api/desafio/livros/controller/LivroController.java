package com.api.desafio.livros.controller;

import com.api.desafio.livros.model.Livro;
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

    @PostMapping("/livro/{id}")
    public void saveLivro(@RequestBody Livro livro){
        livroService.saveLivro(livro);
    }

    @PutMapping("/livro/{id}")
    public Livro putLivro(@RequestBody Livro livro, @PathVariable Long id){
        return putLivro(livro, id);
    }

    @DeleteMapping("/livro/{id}")
    public void deleteLivro(Long id){
        livroService.deleteLivro(id);
    }


}
