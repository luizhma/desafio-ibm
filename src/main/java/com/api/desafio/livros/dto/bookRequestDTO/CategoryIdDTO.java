package com.api.desafio.livros.dto.bookRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryIdDTO implements Serializable {
    private Long id;
}
