package com.api.desafio.livros.config;

import com.api.desafio.livros.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDB {
    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaBaseDeDados() {
        this.dbService.instanciaBaseDeDados();
    }

}
