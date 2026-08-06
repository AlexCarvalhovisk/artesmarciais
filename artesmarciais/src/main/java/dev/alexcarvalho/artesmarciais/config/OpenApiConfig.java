package dev.alexcarvalho.artesmarciais.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//Essa classe é a de inicialização do Swagger
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Academia API")
                        .description(
                                """
                                API para gerenciamento de academia, incluindo:
                                - Cadastro de alunos
                                - Matriculas e planos
                                - Controle financeiro
                                - Relatório gerenciais
                                
                                Projeto desenvolvido com Spring Boot para não perder a pratica.
                                """
                        )
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Alex Carvalho")
                                .email("alexcarvalhovisk@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))
                )
                .servers(List.of(new Server()
                        .url("http://localhost:8080")
                        .description("Servidor local")))
                .externalDocs(new ExternalDocumentation().description("Documentação do projeto")
                        .url("https://github.com/AlexCarvalhovisk/artesmarciais.git"));
    }
}
