package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.authorReponseDTO.AuthorResponseDTO;
import com.api.desafio.livros.dto.authorResquestDTO.AuthorRequestDTO;
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

    @GetMapping("/author")
    @ApiOperation(value = "Retorna uma lista de Autor")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 200, message = "Retorna uma lista de categorias"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public List<AuthorRequestDTO> list() {
        return authorMapper.authorRequestDTOToAuthor(authorService.list());
    }

    @GetMapping("/author/{id}")
    @ApiOperation(value = "Buscar autor por id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 404, message = "Autor não existe"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public AuthorResponseDTO findById(@PathVariable Long id) {
        return authorMapper.authorResponseDTOToEntity(authorService.findById(id));
    }

    @PostMapping("/author")
    @ApiOperation(value = "Adiciona um Autor")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Autor Cadastrado"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public Author insert(@Valid @RequestBody AuthorRequestDTO authorRequestDTO) {
        return authorService.save(authorMapper.authorToAuthorRequestDTO(authorRequestDTO));
    }

    @PutMapping(path = "/author")
    @ApiOperation(value = "Atualiza um Autor")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Solicitação bem sucedida"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Autor não existe"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public ResponseEntity<Author> update(@Valid @RequestBody AuthorRequestDTO authorRequestDTO) {
        authorService.update(authorMapper.authorToAuthorRequestDTO((authorRequestDTO)));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/author/{id}")
    @ApiOperation(value = "Deleta um Autor")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Solicitação bem sucedida"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Autor não existe"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
