package com.api.desafio.livros.repository;

import com.api.desafio.livros.model.Category;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static com.api.desafio.livros.util.CategoryCreator.createCategoryToBeSaved;
import static com.api.desafio.livros.util.CategoryCreator.createValidUpdatedCategory;


@DataJpaTest
@DisplayName("Tests for Category Repository")
@RunWith(SpringRunner.class)
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    @DisplayName("Save persists category when Sucessful")
    public void  savePersistCategory(){
        Category categoryToBeSaved = createCategoryToBeSaved();

        Category categorySaved = this.categoryRepository.save(categoryToBeSaved);

        Assertions.assertThat(categorySaved).isNotNull();
        Assertions.assertThat(categorySaved.getId()).isNotNull();
        Assertions.assertThat(categorySaved.getName()).isEqualTo(categoryToBeSaved.getName());

    }

    @Test
    @DisplayName("Update persists category when Sucessful")
    public void  updatePersistCategory(){
        Category categoryToBeSaved = createValidUpdatedCategory();

        Category categorySaved = this.categoryRepository.save(categoryToBeSaved);

        Assertions.assertThat(categorySaved).isNotNull();
        Assertions.assertThat(categorySaved.getId()).isNotNull();
        Assertions.assertThat(categorySaved.getName()).isEqualTo(categoryToBeSaved.getName());

    }


    @Test
    @DisplayName("Find All category when Sucessful")
    public void findAllBooks(){
        Category categoryToBeSaved = createCategoryToBeSaved();

        Category categorySaved = this.categoryRepository.save(categoryToBeSaved);

        List<Category> categoryList = this.categoryRepository.findAll();

        Assertions.assertThat(categoryList).isNotEmpty();
        Assertions.assertThat(categoryList).contains(categorySaved);


    }

    @Test
    @DisplayName("Deleta category when Sucessful")
    public void  deleteCategory(){
        Category categoryToBeSaved = createCategoryToBeSaved();

        Category categorySaved = this.categoryRepository.save(categoryToBeSaved);
        this.categoryRepository.delete(categorySaved);

        Optional<Category> categoryOptional = this.categoryRepository.findById(categorySaved.getId());

        Assertions.assertThat(categoryOptional).isEmpty();

    }

    @Test
    @DisplayName("Find Id category when Sucessful ")
    public void findCategoryByID(){
        Category categoryToBeSaved = createCategoryToBeSaved();

        Category categorySaved = this.categoryRepository.save(categoryToBeSaved);

       Optional<Category> categoryID = this.categoryRepository.findById(categorySaved.getId());

        Assertions.assertThat(categoryID).isNotEmpty();
        Assertions.assertThat(categoryID).contains(categorySaved);
    }



}