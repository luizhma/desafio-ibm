package com.api.desafio.livros.repository;

import com.api.desafio.livros.model.Category;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static com.api.desafio.livros.util.CategoryCreator.createCategoryToBeSaved;
import static com.api.desafio.livros.util.CategoryCreator.createValidUpdatedCategory;


@DataJpaTest
@DisplayName("Tests for Category Repository")
@RunWith(SpringRunner.class)
@Log4j2
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    @DisplayName("Save persists category when Sucessful")
    public void  savePersistCategory(){
        Category categoryToBeSaved = createCategoryToBeSaved();

        Category categorySaved = this.categoryRepository.save(categoryToBeSaved);

        log.info(categorySaved.toString());
        Assertions.assertThat(categorySaved).isNotNull();
        Assertions.assertThat(categorySaved.getId()).isNotNull();
        Assertions.assertThat(categorySaved.getName()).isEqualTo(categoryToBeSaved.getName());

    }

    @Test
    @DisplayName("Update persists category when Sucessful")
    public void  updatePersistCategory(){
        Category categoryToBeSaved = createValidUpdatedCategory();

        Category categorySaved = this.categoryRepository.save(categoryToBeSaved);

        log.info(categorySaved.toString());
        Assertions.assertThat(categorySaved).isNotNull();
        Assertions.assertThat(categorySaved.getId()).isNotNull();
        Assertions.assertThat(categorySaved.getName()).isEqualTo(categoryToBeSaved.getName());

    }


    @Test
    @DisplayName("Find All category when Sucessful")
    public void findAllCategories(){
        Category categoryToBeSaved = createCategoryToBeSaved();

        Category categorySaved = this.categoryRepository.save(categoryToBeSaved);

        List<Category> categoryList = this.categoryRepository.findAll();

        log.info(categoryList);

        Assertions.assertThat(categoryList).isNotEmpty();
        Assertions.assertThat(categoryList).contains(categorySaved);

    }

    @Test
    @DisplayName("Deleta category when Sucessful")
    public void  deleteCategory(){
        Category categoryToBeSaved = createCategoryToBeSaved();

        Category categorySaved = this.categoryRepository.save(categoryToBeSaved);
        this.categoryRepository.delete(categorySaved);

        log.info(categorySaved.toString());

        Optional<Category> categoryOptional = this.categoryRepository.findById(categorySaved.getId());

        Assertions.assertThat(categoryOptional).isEmpty();

    }

    @Test
    @DisplayName("Find Id category when Sucessful ")
    public void findCategoryByID(){
        Category categoryToBeSaved = createCategoryToBeSaved();

        Category categorySaved = this.categoryRepository.save(categoryToBeSaved);

       Optional<Category> categoryID = this.categoryRepository.findById(categorySaved.getId());

       log.info(categoryID.toString());

        Assertions.assertThat(categoryID).isNotEmpty();
        Assertions.assertThat(categoryID).contains(categorySaved);
    }

    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    public void  saveTrowConstraintViolationExceptionCategoryNameIsEmpty(){
        Category category = new Category();

        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.categoryRepository.save(category))
                .withMessageContaining("Campo NOME ?? requerido");

    }


}