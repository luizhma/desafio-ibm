package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Author;
import com.api.desafio.livros.repository.AuthorRepository;
import com.api.desafio.livros.service.exceptions.ObjectNotFoundException;
import com.api.desafio.livros.util.AuthorCreator;
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

import static com.api.desafio.livros.util.AuthorCreator.createValidUpdatedAuthor;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@Log4j2
public class AuthorServiceTest {

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

        log.info("Lista de Author {}", authorList.toString());

        Assertions.assertThat(authorList).hasSize(1);

    }

    @Test
    @DisplayName("findById returns  author when successful")
    void findByIdReturnAuthorSucessfull() {
        Author author = AuthorCreator.createAuthorToBeSaved();
        log.info("Author criado {} ", author);

        when(authorRepositoryMock.findById(anyLong())).thenReturn(Optional.of(author));

        Author authorSaved = authorService.findById(1L);
        log.info("Author encontrado {} ", authorSaved);

        Assertions.assertThat(authorSaved).isNotNull();
        Assertions.assertThat(authorSaved.getId()).isNotNull().isEqualTo(author.getId());
        Assertions.assertThat(authorSaved.getName()).isNotNull().isEqualTo(author.getName());

    }

    @Test
    @DisplayName("findById returns an of author when id is NoutFoundException")
    void findByIDReturnsEmptyOfAuthorWhenIsNotFoundException() {
        Author author = AuthorCreator.createAuthorToBeSaved();
        log.info("Author criado {} ", author);
        ;

        when(authorRepositoryMock.findById(anyLong())).thenReturn(Optional.empty());

        final Throwable exception = catchThrowable(() -> authorService.findById(1L));

        Assertions.assertThat(exception)
                .isInstanceOf(ObjectNotFoundException.class)
                .hasMessage(String.format("Objeto não encontrado! ID: %s",
                        author.getId() + ", Tipo: " + Author.class.getName()));

    }


    @Test
    @DisplayName("save returns author when successful")
    void saveReturnAuthorSucessfull() {
        Author author = AuthorCreator.createAuthorToBeSaved();
        log.info("Author criado {} ", author);

        when(authorRepositoryMock.save(any(Author.class))).thenReturn(author);

        Author authorSaved = authorService.save(author);
        log.info("Author salvo {} ", authorSaved);

        Assertions.assertThat(authorSaved).isNotNull();
        Assertions.assertThat(authorSaved.getId()).isEqualTo(author.getId());
        Assertions.assertThat(authorSaved.getName()).isEqualTo(author.getName());

    }

    @Test
    @DisplayName("update return  author when successful")
    void updateReturnauthorSucessfull() {
        Author author = AuthorCreator.createAuthorToBeSaved();
        log.info("Author criado {} ", author);

        Author authorToUpdate = createValidUpdatedAuthor();

        when(authorRepositoryMock.save(any(Author.class))).thenReturn(authorToUpdate);
        when(authorRepositoryMock.findById(anyLong())).thenReturn(Optional.of(author));


        Author authorUpdateSaved = authorService.update(author);
        log.info("Author atualizado Atualizada {} ", authorUpdateSaved);

        Assertions.assertThat(author).isNotNull();
        Assertions.assertThat(authorToUpdate.getId()).isNotNull();
        Assertions.assertThat(author.getName()).isNotEqualTo(authorUpdateSaved.getName());

    }

    @Test
    @DisplayName("delete remove  author when successful")
    void deleteRemoveAuthorSucessfull() {
        Author author = AuthorCreator.createAuthorToBeSaved();
        log.info("Author deletado {} ", author);

        when(authorRepositoryMock.save(any(Author.class))).thenReturn(author);
        when(authorRepositoryMock.findById(anyLong())).thenReturn(Optional.of(author));
        doNothing().when(authorRepositoryMock).deleteById(anyLong());


        Author authorSaved = authorService.save(author);
        log.info("Author salvo {} ", authorSaved);

        final Throwable exception = catchThrowable(() -> authorService.delete(authorSaved.getId()));
        log.info("Author deletado {} ", exception);

        Assertions.assertThat(exception).isNull();

        verify(authorRepositoryMock, times(1)).deleteById(anyLong());

    }




}