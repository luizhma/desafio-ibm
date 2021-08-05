package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.repository.CategoryRepository;
import com.api.desafio.livros.service.exceptions.DataIntegrityException;
import com.api.desafio.livros.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrato! ID: " + id + ", Tipo: " + Category.class.getName());
        }
        return category.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found"));
    }


    @Transactional
    public Category save(Category category) {
        Category categorySaved = categoryRepository.save(category);
        return categorySaved;
    }


    @Transactional
    public Category update(Category category) {
        findById(category.getId());
        return categoryRepository.save(category);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Exclusão não permitida, itens vinculados");
        }

    }

}
