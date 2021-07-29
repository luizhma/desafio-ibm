package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.repository.CategoryRepository;
import com.api.desafio.livros.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrato! ID: " + id + ", Tipo: " + Category.class.getName());
        }

        return obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found"));
    }

    @Transactional
    public Category insert(Category obj) {
        if (Objects.isNull(obj.getId()))
            return categoryRepository.save(obj);
        boolean exists = categoryRepository.existsById(obj.getId());
        if (!exists)
            return categoryRepository.save(obj);
        return obj;
    }

    public List<Category> listAll(){
        return categoryRepository.findAll();
    }

/*    @Transactional
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

    public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoryRepository.findAll(pageRequest);
    }*/
}
