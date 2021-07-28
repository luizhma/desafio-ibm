package com.api.desafio.livros.services;

import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.repository.CategoryRepository;
import com.api.desafio.livros.services.exceptions.DataIntegrityException;
import com.api.desafio.livros.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category find(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrato! ID: " + id + ", Tipo: " + Category.class.getName());
        }

        return obj.orElseThrow(() -> new ObjectNotFoundException("Not found"));
    }

    @Transactional
    public Category insert(Category obj) {
        obj.setId(null);
        return categoryRepository.save(obj);
    }

    @Transactional
    public Category update(Category obj) {
        find(obj.getId());
        return categoryRepository.save(obj);
    }

    @Transactional
    public void delete(Long id) {
        find(id);
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Exclusão não permitida, itens vinculados");
        }

    }

    public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoryRepository.findAll(pageRequest);
    }
}
