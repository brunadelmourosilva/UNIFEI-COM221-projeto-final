package br.unifei.imc.lojaprodutos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI productOpenAPI() {
        return new OpenAPI().info(metaData());
    }

    private Info metaData() {
        return new Info()
                .title("API Loja")
                .description("Documentação da API do trabalho final das disciplinas COM211 e COM221")
                .license(new License()
                        .name("Instituto de Matemática e Computação - Universidade Federal de Itajubá")
                        .url("https://unifei.edu.br/"));
    }
}
