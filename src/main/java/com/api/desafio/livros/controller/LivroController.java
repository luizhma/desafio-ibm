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

    @GetMapping("/livros")
    public List<LivroDTO> getLivros(){
        return LivroMapper.INSTANCE.livrosDTOToLivros(livroService.getLivros());
    }

    @GetMapping("/livro/{id}")
    public LivroDTO getLivro(@PathVariable Long id){
        return LivroMapper.INSTANCE.livroDTOToLivro(livroService.getLivro(id).get());
    }

    @PostMapping("/livro")
    public Livro saveLivro(@RequestBody LivroDTO livroDTO){
        return livroService.saveLivro(LivroMapper.INSTANCE.livroToDTO(livroDTO));
    }

    @PutMapping("/livro")
    public Livro putLivro(@RequestBody LivroDTO livroDTO){
        return livroService.putLivro(LivroMapper.INSTANCE.livroToDTO(livroDTO));
    }

    @DeleteMapping("/livro/{id}")
    public void deleteLivro(@PathVariable Long id){
       LivroDTO livroDTO  = LivroMapper.INSTANCE.livroDTOToLivro(livroService.getLivro(id).get());
       livroService.deleteLivro(livroDTO.getId());
    }


}
