package com.api.desafio.livros.config;

import com.api.desafio.livros.dto.requestDTO.LivroRequestDTO;
import com.api.desafio.livros.dto.responseDTO.LivroResponseDTO;
import com.api.desafio.livros.model.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LivroMapper {

    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    LivroRequestDTO livroRequestDTOToLivro(Livro livro);

    Livro livroToLivroRequestDTO(LivroRequestDTO livroRequestDTO);

    List<LivroRequestDTO> livrosRequestDTOToLivros(List<Livro> livros);

    Livro livroToLivroResponseDTO(LivroResponseDTO livroResponseDTO);
}
