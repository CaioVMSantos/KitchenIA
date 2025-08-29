package dev.projeto.ia.KitchenAI.service;

import com.fasterxml.jackson.databind.JsonNode;
import dev.projeto.ia.KitchenAI.model.FoodItem;
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
import java.util.stream.Collectors;

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

    public Mono<String> generateRecipe(List<FoodItem> foodItems) {

        String ingredients = foodItems.stream()
                .map(item -> String.format("%s (%s) - Quantidade: %d, Validade: %s",
                        item.getName(),item.getCategory(), item.getQuantity(), item.getValidity()))
                .collect(Collectors.joining("\n"));

        String prompt = "A partir de agora, você é um cozinheiro, baseado no meu banco de dados, faça uma receita com os seguintes itens: " + ingredients;

        Map<String, Object> buildRequest = Map.of("contents", List.of(Map.of("parts", List.of(Map.of("text", prompt)))));

        return webClient.post()//basicamente setando as informações que são requeridas para usar a api do gemini.
                .uri("/models/gemini-2.0-flash:generateContent")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("X-goog-api-key", geminiApiKey) //geminiApiKey - está sendo usada como variável de ambiente por segurança.
                .bodyValue(buildRequest) //preciso entregar um body com o prompt, por isso crio outro metodo pra fazer isso.
                .retrieve() //executa a requisição Http.
                .bodyToMono(JsonNode.class) // 1. Pede a resposta como um objeto JSON (JsonNode)
                .map(responseNode -> responseNode
                        .path("candidates") // 2. Navega até a lista de "candidates"
                        .get(0)             // 3. Pega o primeiro item da lista
                        .path("content")    // 4. Acessa o objeto "content"
                        .path("parts")      // 5. Acessa a lista de "parts"
                        .get(0)             // 6. Pega o primeiro item da lista
                        .path("text")       // 7. Acessa o campo "text"
                        .asText("Desculpe, não foi possível gerar uma receita."));
    }


}
