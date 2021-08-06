/*
package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.categoryRequestDTO.CategoryRequestDTO;
import com.api.desafio.livros.dto.categoryResponseDTO.CategoryResponseDTO;
import com.api.desafio.livros.model.Book;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.service.CategoryService;
import com.api.desafio.livros.util.CategoryCreator;
import com.api.desafio.livros.util.CategoryRequestDTOCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Tests for Category Controller")
@ExtendWith(SpringExtension.class)
@Log4j2
public class CategoryControllerTest {
    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryServiceMock;



    @BeforeEach
    public void setUp() {
        BDDMockito.when(categoryServiceMock.findAll())
                .thenReturn(Arrays.asList(CategoryCreator.createCategoryToBeSaved()));

        BDDMockito.when((categoryServiceMock.findById(ArgumentMatchers.anyLong())))
                .thenReturn(CategoryCreator.createCategoryToBeSaved());

        BDDMockito.when((categoryServiceMock.save(ArgumentMatchers.any(Category.class))))
                .thenReturn(CategoryCreator.createCategoryToBeSaved());
*/
/*
        BDDMockito.doNothing().when(categoryServiceMock).update(ArgumentMatchers.any(Category.class));

        BDDMockito.doNothing().when(categoryServiceMock).delete(ArgumentMatchers.anyLong());*//*


    }

    @Test
    @DisplayName("ListAll returns list of category when successful")
    public void listAllReturnListOfCategorySucessfull() {
        CategoryRequestDTO expected = CategoryRequestDTOCreator.createCategoryRequestToBeValidSaved();
        //String expectedName = CategoryCreator.createCategoryToBeSaved().getName();
        log.info("Categoria salva {}", expected.toString());

        List<CategoryRequestDTO> categoryList = categoryController.list();
        log.info("Lista de categoria {}", categoryList.stream().toString());

        Assertions.assertThat(categoryList)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(expected);

    }

    @Test
    @DisplayName("findById returns  category when successful")
    public void findByIdReturnCategorySucessfull() {
        Long expectedID = CategoryCreator.createCategoryToBeSaved().getId();
        log.info("ID: {}", expectedID.toString());
        List<Book> books = new ArrayList<>();
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(1L, "teste", books);

        CategoryResponseDTO category = categoryController.findById(categoryResponseDTO.getId());

        Assertions.assertThat(category).isNotNull();
        Assertions.assertThat(category.getId()).isNotNull().isEqualTo(expectedID);


    }


    @Test
    @DisplayName("save returns  category when successful")
    public void saveReturnCategorySucessfull() {

        Category category = categoryController.insert(CategoryRequestDTOCreator.createCategoryRequestToBeSaved());

        Assertions.assertThat(category).isNotNull().isEqualTo(CategoryCreator.createCategoryToBeSaved().getId());


    }


}*/
