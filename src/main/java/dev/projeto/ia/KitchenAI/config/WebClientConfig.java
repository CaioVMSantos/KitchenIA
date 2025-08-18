package dev.projeto.ia.KitchenAI.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${gemini.api.url:https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent}")
    private String geminiUrl;

    @Bean //Um bean é basicamente uma anotação que gera um contexto, eu estou dizendo ao Spring que esse metodo tem um contexto, e que vem de algo externo.
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(geminiUrl).build();
    }

}
