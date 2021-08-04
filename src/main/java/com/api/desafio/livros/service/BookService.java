package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.repository.BookRepository;
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
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorService authorService;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrato! ID: " + id + ", Tipo: " + Book.class.getName());
        }
        return book.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found"));
    }

    @Transactional
    public Book save(Book book) {
        if (book.getCategory().getId() == null) {
            throw new ObjectNotFoundException(
                    "ID de Categoria é obrigatório ");
        } else {
            Optional<Category> category = categoryRepository.findById(book.getCategory().getId());
            if (!category.isPresent()) {
                throw new ObjectNotFoundException(
                        "Objeto não encontrato! ID: " + book.getCategory().getId() + ", Tipo: " + Category.class.getName());
            }
        }

        Book bookSaved = bookRepository.save(book);

        return bookSaved;

    }

    public Book update(Book book) {
        findById(book.getId());
        return bookRepository.save(book);

    }

    public void delete(Long id) {
        findById(id);
        try {
            bookRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Exclusão não permitida, itens vinculados");
        }
    }
}
