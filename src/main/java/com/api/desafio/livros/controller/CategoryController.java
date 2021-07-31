package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.CategoryDTO;
import com.api.desafio.livros.mapper.CategoryMapper;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.service.CategoryService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de categorias")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 200, message = "Retorna uma lista de categorias"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public List<CategoryDTO> list(){
        return categoryMapper.dtosToEntity(categoryService.listAll());
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Buscar categoria por id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 404, message = "Categoria Não existe"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public CategoryDTO findById(@PathVariable Long id){
        return categoryMapper.dtoToEntity(categoryService.findById(id));
    }
    @ApiOperation(value = "Adiciona uma Categoria")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Categoria Cadastrada"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    @PostMapping("/insert")
    public Category insert(@Valid @RequestBody CategoryDTO categoryDTO) {
        return   categoryService.save(categoryMapper.entityToDto(categoryDTO));
    }
    @ApiOperation(value = "Deleta uma Categoria")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Solicitação bem sucedida"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Categoria não existe"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @ApiOperation(value = "Atualiza uma Categoria")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Solicitação bem sucedida"),
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Categoria não existe"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    @PutMapping(path = "/update")
    public ResponseEntity<Category> update(@Valid @RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryMapper.entityToDto(categoryDTO));
        return ResponseEntity.noContent().build();
    }

}
