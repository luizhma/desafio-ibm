package com.api.desafio.livros.controller;

import com.api.desafio.livros.DTO.CategoryDTO;
import com.api.desafio.livros.mapper.CategoryMapper;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping
    public ResponseEntity<List<Category>> list(){
        return new ResponseEntity<>(categoryService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public CategoryDTO insert(@Valid @RequestBody CategoryDTO category) {
        return CategoryMapper.entityToDto(
                categoryService.insert(CategoryMapper.dtoToEntity(category)));
    }


}
