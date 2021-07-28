package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Livro;
import com.api.desafio.livros.dto.requestDto.LivroRequestDto;
import com.api.desafio.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public List<Livro> getLivros(){
       return livroRepository.findAll();
    }

    public Optional<Livro> getLivro(Long id){
        return livroRepository.findById(id);
    }

    public void saveLivro(LivroRequestDto livroRequestDto){
        livroRepository.save(livroRequestDto.buildLivro());
    }

    public Livro putLivro(Livro livro){
        return getLivro(livro.getId())
                .map(livros -> {
                    livros.setSbn(livro.getSbn());
                    livros.setNome(livro.getNome());
                    livros.setDescricao(livro.getDescricao());
                    livros.setEstoque(livro.getEstoque());
                    livros.setClassificacao(livro.getClassificacao());
                    return livroRepository.save(livros);
                }).orElseGet(() -> {
                    livro.setId(livro.getId());
                    return livroRepository.save(livro);
                });
    }

    public void deleteLivro(Long id){
        livroRepository.deleteById(id);
    }
}
