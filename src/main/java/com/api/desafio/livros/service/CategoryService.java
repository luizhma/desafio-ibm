package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.repository.CategoryRepository;
import com.api.desafio.livros.repository.LivroRepository;
import com.api.desafio.livros.service.exceptions.DataIntegrityException;
import com.api.desafio.livros.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;
    private final LivroRepository livroRepository;

    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()){
            throw new ObjectNotFoundException(
                    "Objeto não encontrato! ID: " + id + ", Tipo: " + Category.class.getName());
        }
       return category.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found"));
    }


    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Category update(Category obj) {
        findById(obj.getId());
        return categoryRepository.save(obj);
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
