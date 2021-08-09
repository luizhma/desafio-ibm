package com.api.desafio.livros.controller;

import com.api.desafio.livros.dto.CustomerDTO;
import com.api.desafio.livros.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    @ApiOperation(value = "Retorna uma lista de clientes")
    @ApiIgnore
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Algum problema na requisição"),
            @ApiResponse(code = 200, message = "Retorna uma lista de clientes"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção de sistema"),
    })
    public ResponseEntity<List<CustomerDTO>> list() throws Exception {

        return ResponseEntity.ok(customerService.customers());
    }

}
