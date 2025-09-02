package dev.projeto.ia.KitchenAI.controller;

import dev.projeto.ia.KitchenAI.model.FoodItem;
import dev.projeto.ia.KitchenAI.service.FoodItemService;
import dev.projeto.ia.KitchenAI.service.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/gemini")
public class RecipeController {

    private final GeminiService geminiService;
    private final FoodItemService foodItemService;

    public RecipeController(GeminiService geminiService, FoodItemService foodItemService) {
        this.geminiService = geminiService;
        this.foodItemService = foodItemService;
    }

    @GetMapping("/generateRecipe")
    public Mono<ResponseEntity<String>> generateRecipe(){
        List<FoodItem> foodItems = foodItemService.itemsList();
        return geminiService.generateRecipe(foodItems)
                .map(recipe -> ResponseEntity.ok().body(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}

