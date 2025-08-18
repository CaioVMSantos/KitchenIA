package dev.projeto.ia.KitchenAI.controller;

import dev.projeto.ia.KitchenAI.model.FoodItem;
import dev.projeto.ia.KitchenAI.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    //POST
    @PostMapping("/criar")
    public ResponseEntity<FoodItem> createFood(@RequestBody FoodItem foodItem) {
            FoodItem salvo = foodItemService.saveItem(foodItem);
            return ResponseEntity.ok(salvo);
    }

    //GET
    @GetMapping("/listar")
    public ResponseEntity<List<FoodItem>> getFoodItems() {
            List<FoodItem> listar = foodItemService.itemsList();
            return ResponseEntity.ok(listar);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getFoodItensId(@PathVariable Long id){
        FoodItem foodId = foodItemService.findById(id);
        if(foodId != null){
            return ResponseEntity.ok(foodId);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item com id " +id+ " não encontrado!");
        }
    }

    //UPDATE
    @PutMapping("atualizar/{id}")
    public ResponseEntity<String> updateItem (@PathVariable Long id, @RequestBody FoodItem foodItem) {
        FoodItem existingItem = foodItemService.findById(id);
        if(existingItem != null){
            existingItem.setName(foodItem.getName());
            existingItem.setCategory(foodItem.getCategory());
            existingItem.setQuantity(foodItem.getQuantity());
            existingItem.setValidity(foodItem.getValidity());
            foodItemService.saveItem(existingItem);
            return ResponseEntity.ok("Item atualizado com sucesso!");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item com id " + id + " não encontrado!");
        }
    }

    //DELETE
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id){
        if(foodItemService.itemsList() != null){
            foodItemService.deleteItem(id);
            return ResponseEntity.ok("Item deletado com sucesso!");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item com id " +id+ " não encontrado!");
        }

    }



}
