package dev.projeto.ia.KitchenAI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    private final WebClient webClient;
    @Value("${gemini.api.key}")
    private String geminiApiKey;


    public GeminiService(WebClient webClient) {
        this.webClient = WebClient.builder()
                .baseUrl("https://generativelanguage.googleapis.com/v1beta")
                .build();
    }

    public Mono<String> generateRecipe(String prompt){
        return webClient.post()//basicamente setando as informações que são requeridas para usar a api do gemini.
                .uri("/models/gemini-2.0-flash:generateContent")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("X-goog-api-key", geminiApiKey) //geminiApiKey - está sendo usada como variável de ambiente por segurança.
                .bodyValue(buildRequest(prompt)) //preciso entregar um body com o prompt, por isso crio outro metodo pra fazer isso.
                .retrieve() //executa a requisição Http.
                .bodyToMono(String.class);
    }

    private Map<String, Object> buildRequest(String prompt){
        return Map.of("contents", List.of(Map.of("parts", List.of(Map.of("text", prompt)))));
    }


}
