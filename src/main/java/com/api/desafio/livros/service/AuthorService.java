package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Author;
import com.api.desafio.livros.repository.AuthorRepository;
import com.api.desafio.livros.service.exceptions.DataIntegrityException;
import com.api.desafio.livros.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> list() {
        return authorRepository.findAll();

    }

    public Author findById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (!author.isPresent()) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrato! ID: " + id + ", Tipo: " + Author.class.getName());
        }
        return author.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }


    @Transactional
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Author update(Author author) {
        findById(author.getId());
        return authorRepository.save(author);
    }

    public List<Author> findByNameContaining(@RequestParam(name = "name") String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Author> findByNameOrBiographyContaining(@RequestParam(name = "name") String name, @RequestParam(name ="biography") String biography) {
        return authorRepository.findByNameIgnoreCaseContainingOrBiographyIgnoreCaseContaining(name,biography);
    }

    public void delete(Long id) {
        findById(id);
        try {
            authorRepository.deleteById(id);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException("Exclusão não permitida");
        }
    }
}
