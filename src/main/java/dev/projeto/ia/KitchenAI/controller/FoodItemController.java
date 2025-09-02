package dev.projeto.ia.KitchenAI.controller;

import dev.projeto.ia.KitchenAI.enums.FoodCategory;
import dev.projeto.ia.KitchenAI.model.FoodItem;
import dev.projeto.ia.KitchenAI.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping("/criar")
    public ResponseEntity<FoodItem> createFood(@RequestBody FoodItem foodItem) {
            FoodItem salvo = foodItemService.saveItem(foodItem);
            return ResponseEntity.ok(salvo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FoodItem>> getFoodItems() {
            List<FoodItem> listar = foodItemService.itemsList();
            return ResponseEntity.ok(listar);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getFoodItemsId(@PathVariable Long id){
        FoodItem foodId = foodItemService.findById(id);
        if(foodId != null){
            return ResponseEntity.ok(foodId);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item com id " +id+ " não encontrado!");
        }
    }

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

    @GetMapping("/listarcategorias")
    public ResponseEntity<FoodCategory[]> getFoodCategories(){
        return ResponseEntity.ok(FoodCategory.values());
    }



}
