package com.api.desafio.livros.service;
import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.repository.BookRepository;
import com.api.desafio.livros.repository.CategoryRepository;
import com.api.desafio.livros.service.exceptions.ObjectNotFoundException;
import com.api.desafio.livros.util.BookCreator;
import com.api.desafio.livros.util.CategoryCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class  BookServiceTest {

    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepositoryMock;
    @Mock
    private CategoryRepository categoryRepositoryMock;

    @Test
    @DisplayName("findById returns book when successful")
    void findByIdReturnBookSucessful(){
        Book bookValid = BookCreator.createValidBook();
        BDDMockito.when(bookRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(bookValid));

        Book book = bookService.findById(1L);
        Assertions.assertThat(book).isNotNull();
        Assertions.assertThat(book.getId()).isNotNull().isEqualTo(bookValid.getId());
    }

    @Test
    @DisplayName("findById returns an of book when id is NotFoundException")
    void findByIDReturnsEmptyOfBookWhenIsNotFoundException() {
        Book book = BookCreator.createValidBook();

        when(bookRepositoryMock.findById(anyLong())).thenReturn(Optional.empty());

        final Throwable exception = catchThrowable(() -> bookService.findById(1L));

        Assertions.assertThat(exception)
                .isInstanceOf(ObjectNotFoundException.class)
                .hasMessage(String.format("Objeto não encontrado! ID: %s",
                        book.getId() + ", Tipo: " + Book.class.getName()));
    }

    @Test
    @DisplayName("ListAll returns list of book when successful")
    void listAllReturnListOfBoofSucessful(){
        Book book = BookCreator.createValidBook();
        BDDMockito.when(bookRepositoryMock.findAll())
                .thenReturn(Collections.singletonList(book));

        List<Book> books = bookService.findAll();
        Assertions.assertThat(books)
                .isNotNull()
                .isNotEmpty();

    }

    @Test
    @DisplayName("save returns book when successful")
    void saveAndReturnBookSuccessful(){
        Book book = BookCreator.createValidBook();

        when(bookRepositoryMock.save(any(Book.class)))
                .thenReturn(book);

        when(categoryRepositoryMock.findById(anyLong()))
                .thenReturn(Optional.of(book.getCategory()));

        Book bookSaved = bookService.save(book);

        Assertions.assertThat(bookSaved).isNotNull();
        Assertions.assertThat(book).isEqualTo(bookSaved);
    }


    @Test
    @DisplayName("update return  category when successful")
    void updateReturnBookSucessful(){
        Book createdBook = BookCreator.createValidBook();

        Book updateBook = BookCreator.createValidUpdatedBook();

        when(bookRepositoryMock.save(any(Book.class)))
                .thenReturn(updateBook);

        when(bookRepositoryMock.findById(anyLong()))
                .thenReturn(Optional.of(createdBook));

        Book bookUpdateSaved = bookService.update(createdBook);

        Assertions.assertThat(createdBook).isNotNull();
        Assertions.assertThat(bookUpdateSaved.getId()).isNotNull();
        Assertions.assertThat(createdBook.getNome()).isNotEqualTo(bookUpdateSaved.getNome());

    }

    @Test
    @DisplayName("delete remove book when successful")
    void deleteRemoveCategorySucessful(){
        Book createdBook = BookCreator.createValidBook();
        BDDMockito.doNothing().when(bookRepositoryMock).delete(ArgumentMatchers.any(Book.class));

        when(bookRepositoryMock.save(any(Book.class)))
                .thenReturn(createdBook);

        when(bookRepositoryMock.findById(anyLong()))
                .thenReturn(Optional.of(createdBook));

        Assertions.assertThatCode(() ->bookService.delete(1L))
                .doesNotThrowAnyException();

    }
}
