package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.CategoryDTO;
import com.api.desafio.livros.mapper.CategoryMapper;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.service.CategoryService;
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
    public List<CategoryDTO> list(){
        return categoryMapper.dtosToEntity(categoryService.listAll());
    }

    @GetMapping(path = "/{id}")
    public CategoryDTO findById(@PathVariable Long id){
        return categoryMapper.dtoToEntity(categoryService.findById(id));
    }

    @PostMapping("/insert")
    public Category insert(@Valid @RequestBody CategoryDTO categoryDTO) {
        return   categoryService.save(categoryMapper.entityToDto(categoryDTO));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Category> update(@Valid @RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryMapper.entityToDto(categoryDTO));
        return ResponseEntity.noContent().build();
    }

}
