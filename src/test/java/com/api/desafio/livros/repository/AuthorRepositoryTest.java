package com.api.desafio.livros.repository;

import com.api.desafio.livros.model.Author;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.api.desafio.livros.util.AuthorCreator.createAuthorToBeSaved;
import static com.api.desafio.livros.util.AuthorCreator.createValidUpdatedAuthor;

@DataJpaTest
@DisplayName("Tests for Autor Repository")
@RunWith(SpringRunner.class)
@Log4j2
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @DisplayName("Save persists Author  Sucessful")
    public void  savePersistAuthor(){
        Author authorToBeSaved = createAuthorToBeSaved();

        Author authorSaved = this.authorRepository.save(authorToBeSaved);

        log.info(authorSaved.toString());
        Assertions.assertThat(authorSaved).isNotNull();
        Assertions.assertThat(authorSaved.getId()).isNotNull();
        Assertions.assertThat(authorSaved.getName()).isEqualTo(authorToBeSaved.getName());
        Assertions.assertThat(authorSaved.getBiography()).isEqualTo(authorToBeSaved.getBiography());
        Assertions.assertThat(authorSaved.getBirthdate()).isEqualTo(authorToBeSaved.getBirthdate());
        Assertions.assertThat(authorSaved.getNationality()).isEqualTo(authorToBeSaved.getNationality());

    }

    @Test
    @DisplayName("Update persists Author when Sucessful")
    public void  updatePersistAuthor(){

        Author authorToBeSaved = createValidUpdatedAuthor();

        Author authorSaved = this.authorRepository.save(authorToBeSaved);

        log.info(authorSaved.toString());
        Assertions.assertThat(authorSaved).isNotNull();
        Assertions.assertThat(authorSaved.getId()).isNotNull();
        Assertions.assertThat(authorSaved.getName()).isEqualTo(authorToBeSaved.getName());
        Assertions.assertThat(authorSaved.getBiography()).isEqualTo(authorToBeSaved.getBiography());
        Assertions.assertThat(authorSaved.getBirthdate()).isEqualTo(authorToBeSaved.getBirthdate());
        Assertions.assertThat(authorSaved.getNationality()).isEqualTo(authorToBeSaved.getNationality());

    }


}

