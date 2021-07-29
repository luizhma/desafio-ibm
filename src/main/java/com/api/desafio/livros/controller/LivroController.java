package com.api.desafio.livros.controller;

import com.api.desafio.livros.config.LivroMapper;
import com.api.desafio.livros.model.Livro;
import com.api.desafio.livros.dto.requestDTO.LivroRequestDTO;
import com.api.desafio.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping("/livros")
    public List<LivroRequestDTO> getLivros(){
        return LivroMapper.INSTANCE.livrosRequestDTOToLivros(livroService.getLivros());
    }

    @GetMapping("/livro/{id}")
    public LivroRequestDTO getLivro(@PathVariable Long id){
        return LivroMapper.INSTANCE.livroRequestDTOToLivro(livroService.getLivro(id));
    }

    @PostMapping("/livro")
    public void saveLivro(@RequestBody LivroRequestDTO livroRequestDTO){
        livroService.saveLivro(LivroMapper.INSTANCE.livroToLivroRequestDTO(livroRequestDTO));
    }

    @PutMapping("/livro")
    public Livro putLivro(@RequestBody LivroRequestDTO livroRequestDTO){
        return livroService.putLivro(LivroMapper.INSTANCE.livroToLivroRequestDTO(livroRequestDTO));
    }

    @DeleteMapping("/livro/{id}")
    public void deleteLivro(@PathVariable Long id){
        livroService.deleteLivro(id);
    }


}
