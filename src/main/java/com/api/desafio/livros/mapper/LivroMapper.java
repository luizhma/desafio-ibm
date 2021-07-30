package com.api.desafio.livros.mapper;

import com.api.desafio.livros.DTO.LivroDTO;
import com.api.desafio.livros.model.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")
public interface LivroMapper {

    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    LivroDTO livroDTOToLivro(Livro livro);

    List<LivroDTO> livrosDTOToLivros(List<Livro> livro);

    Livro livroToDTO(LivroDTO livroDTO);
}
