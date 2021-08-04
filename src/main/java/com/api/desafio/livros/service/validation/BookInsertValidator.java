package com.api.desafio.livros.service.validation;

import com.api.desafio.livros.controller.exception.FieldMessage;
import com.api.desafio.livros.dto.bookRequestDTO.BookRequestDTO;
import com.api.desafio.livros.model.Category;
import com.api.desafio.livros.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookInsertValidator implements ConstraintValidator<BookInsert, BookRequestDTO> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean isValid(BookRequestDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getCategory().getId() == null || objDto.getCategory().getId().toString().isEmpty()) {
            list.add(new FieldMessage("Category", "Preenchimento obrigatório"));
        } else {
            Optional<Category> category = Optional.ofNullable(categoryService.findById(objDto.getCategory().getId()));
            if (!category.isPresent()) {
                list.add(new FieldMessage("Category", "Categoria Não Cadastrada"));
            }
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}