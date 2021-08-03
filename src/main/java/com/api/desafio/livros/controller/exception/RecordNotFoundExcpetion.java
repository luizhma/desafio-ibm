package com.api.desafio.livros.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Request source is not avialabre")
public class RecordNotFoundExcpetion extends  RuntimeException {

    private static final long serialVersionUID = 1L;

}
