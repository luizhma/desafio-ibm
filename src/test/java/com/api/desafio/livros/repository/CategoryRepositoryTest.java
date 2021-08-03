package com.api.desafio.livros.repository;

import com.api.desafio.livros.model.Category;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.api.desafio.livros.util.CategoryCreator.createCategoryToBeSaved;
import static com.api.desafio.livros.util.CategoryCreator.createValidUpdatedCategory;


@DataJpaTest
@DisplayName("Tests for Category Repository")
@RunWith(SpringRunner.class)
public class CategoryRepositoryTest {
    @Mock
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

}