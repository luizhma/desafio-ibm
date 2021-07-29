package com.api.desafio.livros.controller;

import com.api.desafio.livros.config.LivroMapper;
import com.api.desafio.livros.model.Livro;
import com.api.desafio.livros.dto.LivroDTO;
import com.api.desafio.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivroController {

    @Autowired
    LivroService livroService;

    @Autowired
    LivroMapper livroMapper;


    @GetMapping("/livros")
    public List<LivroDTO> getLivros(){
        return livroMapper.livrosDTOToLivros(livroService.getLivros());
    }

    @GetMapping("/livro/{id}")
    public LivroDTO getLivro(@PathVariable Long id){
        return livroMapper.livroDTOToLivro(livroService.getLivro(id).get());
    }

    @PostMapping("/livro")
    public Livro saveLivro(@RequestBody LivroDTO livroDTO){
        return livroService.saveLivro(livroMapper.livroToDTO(livroDTO));
    }

    @PutMapping("/livro")
    public Livro putLivro(@RequestBody LivroDTO livroDTO){
        return livroService.putLivro(livroMapper.livroToDTO(livroDTO));
    }

    @DeleteMapping("/livro/{id}")
    public void deleteLivro(@PathVariable Long id){
       LivroDTO livroDTO  = livroMapper.livroDTOToLivro(livroService.getLivro(id).get());
       livroService.deleteLivro(livroDTO.getId());
    }


}
