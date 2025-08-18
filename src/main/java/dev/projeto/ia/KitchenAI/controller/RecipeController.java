package dev.projeto.ia.KitchenAI.controller;

import dev.projeto.ia.KitchenAI.model.FoodItem;
import dev.projeto.ia.KitchenAI.service.FoodItemService;
import dev.projeto.ia.KitchenAI.service.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gemini")
public class RecipeController {

    private GeminiService geminiService;
    private FoodItemService foodItemService;

    public RecipeController(GeminiService geminiService, FoodItemService foodItemService) {
        this.geminiService = geminiService;
        this.foodItemService = foodItemService;
    }

    @GetMapping("/generateRecipe")
    public Mono<ResponseEntity<String>> generateRecipe(){ //Mono: Assíncrono, faz uma especie de promessa que diz que ao enviar algo, algo irá retornar, mesmo que não seja no mesmo periodo de tempo.
        List<FoodItem> foodItems = foodItemService.itemsList();
        return geminiService.generateRecipe(foodItems)
                .map(recipe -> ResponseEntity.ok().body(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}

