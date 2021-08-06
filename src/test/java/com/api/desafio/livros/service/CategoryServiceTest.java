package com.api.desafio.livros.service;

import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.repository.CategoryRepository;
import com.api.desafio.livros.service.exceptions.ObjectNotFoundException;
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
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepositoryMock;

    @BeforeEach
    public void setUp() {
        categoryService = new CategoryService(categoryRepositoryMock);
    }

    @Test
    @DisplayName("ListAll returns list of category when successful")
    void listAllReturnListOfCategorySucessfull() {
        Category category = CategoryCreator.createCategoryToBeSaved();
        log.info("Categoria criada {} ", category);

        when(categoryRepositoryMock.findAll()).thenReturn(Collections.singletonList(category));
        List<Category> categoryList = categoryRepositoryMock.findAll();

        log.info("Lista de categoria {}", categoryList.toString());

        Assertions.assertThat(categoryList).hasSize(1);

    }

    @Test
    @DisplayName("findById returns  category when successful")
    void findByIdReturnCategorySucessfull() {
        Category category = CategoryCreator.createCategoryToBeSaved();
        log.info("Categoria criada {} ", category);

        when(categoryRepositoryMock.findById(anyLong())).thenReturn(Optional.of(category));

        Category categorySaved = categoryService.findById(1L);
        log.info("Categoria encontrando {} ", categorySaved);

        Assertions.assertThat(categorySaved).isNotNull();
        Assertions.assertThat(categorySaved.getId()).isNotNull().isEqualTo(category.getId());
        Assertions.assertThat(categorySaved.getName()).isNotNull().isEqualTo(category.getName());

    }

    @Test
    @DisplayName("findById returns an of category when id is NoutFoundException")
    void findByIDReturnsEmptyOfCategoryWhenIsNotFoundException() {
        Category category = CategoryCreator.createCategoryToBeSaved();
        log.info("Categoria criada {} ", category);
        ;

        when(categoryRepositoryMock.findById(anyLong())).thenReturn(Optional.empty());

        final Throwable exception = catchThrowable(() -> categoryService.findById(1L));

        Assertions.assertThat(exception)
                .isInstanceOf(ObjectNotFoundException.class)
                .hasMessage(String.format("Objeto não encontrado! ID: %s",
                        category.getId() + ", Tipo: " + Category.class.getName()));

    }


    @Test
    @DisplayName("save returns category when successful")
    void saveReturnCategorySucessfull() {
        Category category = CategoryCreator.createCategoryToBeSaved();
        log.info("Categoria criada {} ", category);

        when(categoryRepositoryMock.save(any(Category.class))).thenReturn(category);

        Category categorySaved = categoryService.save(category);
        log.info("Categoria salva {} ", categorySaved);

        Assertions.assertThat(categorySaved).isNotNull();
        Assertions.assertThat(categorySaved.getId()).isEqualTo(category.getId());
        Assertions.assertThat(categorySaved.getName()).isEqualTo(category.getName());

    }

    @Test
    @DisplayName("delete remove  category when successful")
    void deleteRemoveCategorySucessfull() {
        Category category = CategoryCreator.createCategoryToBeSaved();
        log.info("Categoria criada {} ", category);

        when(categoryRepositoryMock.save(any(Category.class))).thenReturn(category);
        when(categoryRepositoryMock.findById(anyLong())).thenReturn(Optional.of(category));
        doNothing().when(categoryRepositoryMock).deleteById(anyLong());


        Category categorySaved = categoryService.save(category);
        log.info("Categoria salva {} ", categorySaved);

        final Throwable exception = catchThrowable(() -> categoryService.delete(categorySaved.getId()));
        log.info("Categoria deleteda {} ", exception);

        Assertions.assertThat(exception).isNull();

        verify(categoryRepositoryMock, times(1)).deleteById(anyLong());

    }
/*    @Test
    @DisplayName("update return  category when successful")
    void updateReturnCategorySucessfull() {
        Category category = CategoryCreator.createCategoryToBeSaved();
        log.info("Categoria criada {} ", category);

        when(categoryRepositoryMock.save(any(Category.class))).thenReturn(category);
        when(categoryRepositoryMock.findById(anyLong())).thenReturn(Optional.of(category));

        Category categorySaved = categoryService.save(category);
        log.info("Categoria salva {} ", categorySaved);



        final Throwable exception = catchThrowable(() -> categoryService.update(categorySaved));
        log.info("Categoria exception {} ", exception);


        Assertions.assertThat(exception).isNull();
        Assertions.assertThat(categorySaved).isNotNull();


    }*/



}