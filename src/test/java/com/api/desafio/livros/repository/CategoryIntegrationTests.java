package com.api.desafio.livros.repository;

import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.service.CategoryService;
import com.api.desafio.livros.service.exceptions.ObjectNotFoundException;
import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryIntegrationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    @DisplayName("Insert Category")
    public void createCategory(){
        List<Book> books = new ArrayList<>();
        Category category =  new Category(null,"Informática",books);
        category = categoryService.save(category);

      Assertions.assertThat(category).isNotNull();
      Assertions.assertThat(category.getName()).isNotNull();

    }
    @Test(expected = ConstraintViolationException.class)
    @DisplayName("Fail Insert Category unnamed")
    public void failCreateCategory(){
        Category category =  Category.builder()
                .name("")
                .build();
        category = categoryService.save(category);

        Assertions.assertThat(category).isNotNull();
        Assertions.assertThat(category.getName()).isNotNull();
    }

    @Test
    @DisplayName("Update Category")
    public void updateCategory(){
        Category category =  Category.builder()
                .id(1l)
                .name("Update")
                .build();
        category = categoryService.update(category);

        Assertions.assertThat(category.getId()).isNotNull();
        Assertions.assertThat(category).isNotNull();
        Assertions.assertThat(category.getName()).isNotNull();

    }

    @Test(expected = ObjectNotFoundException.class)
    @DisplayName("Fail Update Category")
    public void failUpdateCategory(){
        Category category =  Category.builder()
                .id(null)
                .name("Update")
                .build();
        category = categoryService.update(category);

        Assertions.assertThat(category.getId()).isNotNull();
        Assertions.assertThat(category).isNotNull();
        Assertions.assertThat(category.getName()).isNotNull();

    }

}
