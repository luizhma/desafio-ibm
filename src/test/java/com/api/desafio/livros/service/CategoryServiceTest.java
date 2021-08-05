package com.api.desafio.livros.service;

import com.api.desafio.livros.dto.categoryRequestDTO.CategoryRequestDTO;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.repository.CategoryRepository;
import com.api.desafio.livros.util.CategoryCreator;
import com.api.desafio.livros.util.CategoryRequestDTOCreator;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
@Log4j2
@DisplayName("Tests for Category Service")
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepositoryMock;


    @BeforeEach
    public void setUp(){

        BDDMockito.when(categoryRepositoryMock.findAll())
                .thenReturn(Arrays.asList(CategoryCreator.createCategoryValidCategory()));

        BDDMockito.when((categoryRepositoryMock.findById(ArgumentMatchers.anyLong())))
                .thenReturn(Optional.of(CategoryCreator.createCategoryValidCategory()));

        BDDMockito.when((categoryRepositoryMock.save(ArgumentMatchers.any(Category.class))))
                .thenReturn(CategoryCreator.createCategoryValidCategory());

        BDDMockito.doNothing().when(categoryRepositoryMock).save(ArgumentMatchers.any(Category.class));

        BDDMockito.doNothing().when(categoryRepositoryMock).deleteById(ArgumentMatchers.anyLong());

    }

    @Test
    @DisplayName("ListAll returns list of category when successful")
    public void listAllReturnListOfCategorySucessfull(){
        CategoryRequestDTO expected = CategoryRequestDTOCreator.createCategoryRequestToBeValidSaved();
        //String expectedName = CategoryCreator.createCategoryValidCategory().getName();
        log.info("Categoria salva {}", expected.toString());

        List<Category> categoryList = categoryService.findAll();
        log.info("Lista de categoria {}", categoryList.stream().toString());

        Assertions.assertThat(categoryList)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(expected);

    }

    @Test
    @DisplayName("findById returns  category when successful")
    public void findByIdReturnCategorySucessfull(){
        Long expectedID = CategoryCreator.createCategoryValidCategory().getId();
        log.info("ID: {}", expectedID.toString());

        Category category = categoryService.findById(1L);

        Assertions.assertThat(category).isNotNull();
        Assertions.assertThat(category.getId()).isNotNull().isEqualTo(expectedID);


    }

    @Test
    @DisplayName("findById returns an of category when id is not found")
    public void findByIDReturnsEmptyOfCategoryWhenIsNotFound(){
        BDDMockito.when((categoryRepositoryMock.findById(ArgumentMatchers.anyLong())))
                .thenReturn(Optional.of(CategoryCreator.createCategoryValidCategory()));

        Category category = categoryService.findById(1L);

        Assertions.assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> this.categoryRepositoryMock.save(category))
                .withMessageContaining("Objeto não encontrato!");

    }


    @Test
    @DisplayName("save returns category when successful")
    public void saveReturnCategorySucessfull(){

        Category category = categoryService.save(CategoryCreator.createCategoryToBeSaved());

        Assertions.assertThat(category).isNotNull().isEqualTo(CategoryCreator.createCategoryToBeSaved());

    }

    @Test
    @DisplayName("updates category when successful")
    public void UpdatesCategory_WhenSuccessful(){

        Assertions.assertThatCode(() -> categoryService.update(CategoryCreator.createValidUpdatedCategory()))
                .doesNotThrowAnyException();
    }


}