package com.api.desafio.livros.service.exceptions;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }

    private static final long serialVersionUID = -2204857113749453290L;
}
