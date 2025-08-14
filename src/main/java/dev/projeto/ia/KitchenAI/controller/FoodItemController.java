package dev.projeto.ia.KitchenAI.controller;

import dev.projeto.ia.KitchenAI.model.FoodItem;
import dev.projeto.ia.KitchenAI.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    //POST
    @PostMapping
    public ResponseEntity<FoodItem> createFood(@RequestBody FoodItem foodItem) {
            FoodItem salvo = foodItemService.saveItem(foodItem);
            return ResponseEntity.ok(salvo);
    }

    //GET
    public List<FoodItem> getFoodItems() {


    }
    //UPDATE
    //DELETE



}
