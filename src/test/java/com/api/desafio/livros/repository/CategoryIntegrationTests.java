package com.api.desafio.livros.repository;

import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.service.CategoryService;
import com.api.desafio.livros.service.exceptions.ObjectNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.api.desafio.livros.util.CategoryCreator.createCategoryToBeSaved;
import static com.api.desafio.livros.util.CategoryCreator.createValidUpdatedCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class CategoryIntegrationTests {

    @Autowired
    private CategoryService categoryService;


    @Test
    @DisplayName("Insert Category")
    public void createCategory() {
        List<Book> books = new ArrayList<>();
        Category categoryToBeSaved = createCategoryToBeSaved();
        Category categorySaved = categoryService.save(categoryToBeSaved);

        log.info(categorySaved.toString());

        Assertions.assertThat(categorySaved).isNotNull();
        Assertions.assertThat(categorySaved.getName()).isNotNull();

    }

    @Test
    @DisplayName("Fail Insert Category unnamed")
    public void failCreateCategory() {
        Category category = Category.builder()
                .name(null)
                .build();
        Assertions.assertThatExceptionOfType(javax.validation.ConstraintViolationException.class)
                .isThrownBy(() -> this.categoryService.save(category))
                .withMessageContaining("Campo NOME é requerido");
    }

/*
    @Test
    @DisplayName("Update Category")
    public void updateCategory() {
        Category category = createCategoryToBeSaved();
        Category categorySavedToBase = this.categoryService.save(category);
        Category categoryToBeSaved = createValidUpdatedCategory();
        Category categorySaved = categoryService.update(categoryToBeSaved);

        Optional<Category> categoryOptional = Optional.ofNullable(
                this.categoryService.findById(categorySaved.getId()));


        log.info(categorySaved.toString());
        Assertions.assertThat(categoryOptional).isEmpty();

    }
*/

    @Test(expected = ObjectNotFoundException.class)
    @DisplayName("Fail Update Category")
    public void failUpdateCategory() {
        Category categoryToBeSaved = createValidUpdatedCategory();
        Category categorySaved = categoryService.update(categoryToBeSaved);

        log.info(categorySaved.toString());

        Assertions.assertThat(categorySaved.getId()).isNotNull();
        Assertions.assertThat(categorySaved).isNotNull();
        Assertions.assertThat(categorySaved.getName()).isNotNull();

    }

}
