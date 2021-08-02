package com.api.desafio.livros.repository;

import com.api.desafio.livros.model.Author;
import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.model.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("Save Book")
    public void createBookPersistData(){
        List<Book> books = new ArrayList<>();
        Category category = new Category(1L, "1232342", books);
        Book bookSaved = new Book(1L,"123", "nomeTeste", "descricaoTeste", 2, 2.0, category);
        this.bookRepository.save(bookSaved);

        Assertions.assertThat(bookSaved).isNotNull();
        Assertions.assertThat(bookSaved.getId()).isNotNull();
        Assertions.assertThat(bookSaved.getCategory()).isNotNull();
    }

    @Test
    @DisplayName("Update Book")
    public void updateBook(){
        List<Book> books = new ArrayList<>();
        Category category = new Category(1L, "1232342", books);
        Book bookSaved = new Book(1L,"123", "nomeTeste", "descricaoTeste", 2, 2.0, category);
        this.bookRepository.save(bookSaved);

        bookSaved.setNome("NovoNome");

        Book bookUpdated = this.bookRepository.save(bookSaved);

        Assertions.assertThat(bookUpdated).isNotNull();
        Assertions.assertThat(bookUpdated.getId()).isNotNull();
        Assertions.assertThat(bookUpdated.getCategory()).isNotNull();
        Assertions.assertThat(bookUpdated.getNome()).isEqualTo(bookSaved.getNome());
    }

    @Test
    @DisplayName("Delete Book")
    public void deleteBook(){
        List<Book> books = new ArrayList<>();
        Category category = new Category(1L, "1232342", books);
        Book bookSaved = new Book(1L,"123", "nomeTeste", "descricaoTeste", 2, 2.0, category);
        this.bookRepository.save(bookSaved);
        this.bookRepository.delete(bookSaved);

        Optional <Book> optionalBook = this.bookRepository.findById(bookSaved.getId());

        Assertions.assertThat(optionalBook).isEmpty();
    }

    @Test
    @DisplayName("FindAll Books")
    public void findAllBooks(){
        List<Book> books = new ArrayList<>();
        Category category = new Category(1L, "1232342", books);
        Book bookSaved = new Book(1L,"123", "nomeTeste", "descricaoTeste", 2, 2.0, category);
        this.bookRepository.save(bookSaved);

        List<Book> booksToBeFinded = bookRepository.findAll();

        Assertions.assertThat(booksToBeFinded).isNotEmpty();
        Assertions.assertThat(booksToBeFinded).contains(bookSaved);
    }

    @Test
    @DisplayName("Find Book ById")
    public void findBookById(){
        List<Book> books = new ArrayList<>();
        Category category = new Category(1L, "1232342", books);
        Book bookSaved = new Book(1L,"123", "nomeTeste", "descricaoTeste", 2, 2.0, category);
        this.bookRepository.save(bookSaved);

        Long id = bookSaved.getId();

        Optional<Book> OptionalBook = this.bookRepository.findById(id);

        Assertions.assertThat(OptionalBook).isNotEmpty();
        Assertions.assertThat(OptionalBook).contains(bookSaved);
    }
}