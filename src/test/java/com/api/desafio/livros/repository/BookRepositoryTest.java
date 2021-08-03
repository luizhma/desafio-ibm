package com.api.desafio.livros.repository;

import com.api.desafio.livros.controller.AuthorController;
import com.api.desafio.livros.controller.BookController;
import com.api.desafio.livros.controller.CategoryController;
import com.api.desafio.livros.model.Author;
import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.service.AuthorService;
import com.api.desafio.livros.service.BookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookRepositoryTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private CategoryRepository categoryRepositor;

    @Test
    @DisplayName("Save Book")
    public void createBookPersistData(){
        Category category = new Category();
        Book bookSaved = new Book(1L,"123", "nomeTeste",
                "descricaoTeste", 2, 2.0, category);
        this.bookRepository.save(bookSaved);

        Assertions.assertThat(bookSaved).isNotNull();
        Assertions.assertThat(bookSaved.getId()).isNotNull();
        Assertions.assertThat(bookSaved.getCategory()).isNotNull();
    }

    @Test
    @DisplayName("Update Book")
    public void updateBook(){
        Category category = new Category();
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
        Category category = new Category();
        Book bookSaved = new Book(1L,"123", "nomeTeste", "descricaoTeste", 2, 2.0, category);
        bookRepository.save(bookSaved);
        this.bookRepository.delete(bookSaved);

        Optional <Book> optionalBook = this.bookRepository.findById(bookSaved.getId());

        Assertions.assertThat(optionalBook).isEmpty();
    }

    @Test
    @DisplayName("FindAll Books")
    public void findAllBooks(){
        List<Book> books = new ArrayList<>();
        Category category = new Category(1L, "Nome da Categoria", books);
        this.categoryRepositor.save(category);
        Book bookSaved = new Book(1L,"123", "nomeTeste", "descricaoTeste", 2, 2.0, category);
        this.bookRepository.save(bookSaved);

        List<Book> booksToBeFinded = bookRepository.findAll();
        Assertions.assertThat(booksToBeFinded).isNotEmpty();

    }

    @Test
    @DisplayName("Find Book ById")
    public void findBookById(){
        Category category = new Category();
        Book bookSaved = new Book(1L,"123", "nomeTeste", "descricaoTeste", 2, 2.0, category);
        this.bookRepository.save(bookSaved);

        Long id = bookSaved.getId();

        Optional<Book> OptionalBook = this.bookRepository.findById(id);

        Assertions.assertThat(OptionalBook).isNotEmpty();
        Assertions.assertThat(OptionalBook).contains(bookSaved);
    }
}