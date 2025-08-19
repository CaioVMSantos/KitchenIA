package dev.projeto.ia.KitchenAI.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI kitchenOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(" KITCHENIA API")
                        .description("Documentação da API do sistema Kitchen IA")
                        .version("1.0.0"));
    }



}
