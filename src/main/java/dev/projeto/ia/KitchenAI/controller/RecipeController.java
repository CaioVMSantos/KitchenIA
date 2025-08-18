package dev.projeto.ia.KitchenAI.controller;

import dev.projeto.ia.KitchenAI.service.GeminiService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/gemini")
public class RecipeController {

    private GeminiService geminiService;

    public RecipeController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/generateRecipe")
    public Mono<String> generateRecipe(@RequestBody Map<String, String> request){ //Mono: Assíncrono, faz uma especie de promessa que diz que ao enviar algo, algo irá retornar, mesmo que não seja no mesmo periodo de tempo.
        String prompt = request.get("prompt");
        return geminiService.generateRecipe(prompt);
    }

}

