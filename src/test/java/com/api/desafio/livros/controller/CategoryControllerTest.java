package com.api.desafio.livros.controller;

import com.api.desafio.livros.service.CategoryService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
class CategoryControllerTest {
    @InjectMocks
    private CategoryController controller;

    @Mock
    private CategoryService categoryService;



}