package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Author;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.repository.AuthorRepository;
import com.api.desafio.livros.repository.CategoryRepository;
import com.api.desafio.livros.service.exceptions.ObjectNotFoundException;
import com.api.desafio.livros.util.AuthorCreator;
import com.api.desafio.livros.util.CategoryCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Log4j2
public class AuhtorServiceTest_Old {

    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepositoryMock;

    @BeforeEach
    public void setUp() {
        authorService = new AuthorService(authorRepositoryMock);
    }

    @Test
    @DisplayName("ListAll returns list of author when successful")
    void listAllReturnListOfAuthorSucessfull() {

        Author author = AuthorCreator.createAuthorToBeSaved();
        log.info("Author criado {} ", author);
        when(authorRepositoryMock.findAll()).thenReturn(Collections.singletonList(author));
        List<Author> authorList = authorRepositoryMock.findAll();
        log.info("Lista de Autores ", authorList.toString());
        Assertions.assertThat(authorList).hasSize(1);

    }

    @Test
    @DisplayName("save and return author wen sucessful")
    void saveReturnAuthorSucessfull(){
        Author author = AuthorCreator.createAuthorToBeSaved();
        log.info("Author criado {}", author);

        when(authorRepositoryMock.save(any(Author.class))).thenReturn(author);

        Author authorSaved = authorService.save(author);
        log.info("Autor salvo{}", authorSaved);

        Assertions.assertThat(authorSaved).isNotNull();
        Assertions.assertThat(authorSaved.getId()).isEqualTo(author.getId());
        Assertions.assertThat(authorSaved.getName()).isEqualTo(author.getName());
        Assertions.assertThat(authorSaved.getNationality()).isEqualTo(author.getNationality());

    }

    @Test
    @DisplayName("findById returns an of author when id is NotFoundException")
    void findByIDReturnsEmptyOfAuthorWhenIsNotFoundException() {
        Author author = AuthorCreator.createAuthorToBeSaved();
        log.info("Autor criado {} ", author);
        ;

        when(authorRepositoryMock.findById(anyLong())).thenReturn(Optional.empty());

        final Throwable exception = catchThrowable(() -> authorService.findById(1L));

        Assertions.assertThat(exception)
                .isInstanceOf(ObjectNotFoundException.class)
                .hasMessage(String.format("Objeto não encontrado! ID: %s ", author.getId() + ", Tipo: " + Author.class.getName()));

    }

    @Test
    @DisplayName("delete remove author when successful")
    void deleteRemoveAuthorSucessfull() {
        Author author = AuthorCreator.createAuthorToBeSaved();
        log.info("Author criado {} ", author);

        when(authorRepositoryMock.save(any(Author.class))).thenReturn(author);
        when(authorRepositoryMock.findById(anyLong())).thenReturn(Optional.of(author));
        doNothing().when(authorRepositoryMock).deleteById(anyLong());


        Author authorSaved = authorService.save(author);
        log.info("Autor Salvo {} ", authorSaved);

        final Throwable exception = catchThrowable(() -> authorService.delete(authorSaved.getId()));
        log.info("Author Excluído {} ", exception);

        Assertions.assertThat(exception).isNull();

        verify(authorRepositoryMock, times(1)).deleteById(anyLong());

    }

//    @Test
//    @DisplayName("update remove author when successful")
//    void updateReturnAuthorSucessfull() {
//        Author author = AuthorCreator.createAuthorToBeSaved();
//        log.info("Author criado {} ", author);
//
//        when(authorRepositoryMock.save(any(Author.class))).thenReturn(author);
//        when(authorRepositoryMock.findById(anyLong())).thenReturn(Optional.of(author));
//        doNothing().when(authorRepositoryMock).deleteById(anyLong());
//
//
//        Author authorSaved = authorService.save(author);
//        log.info("Autor Salvo {} ", authorSaved);
//
//        final Throwable exception = catchThrowable(() -> authorService.delete(authorSaved.getId()));
//        log.info("Author Excluído {} ", exception);
//
//        Assertions.assertThat(exception).isNull();
//
//        verify(authorRepositoryMock, times(1)).deleteById(anyLong());
//
//    }


}
