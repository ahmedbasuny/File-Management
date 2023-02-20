package com.stc.filemanagment;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FileManagmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileManagmentApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("STC file management system").version("1.0.1")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}

