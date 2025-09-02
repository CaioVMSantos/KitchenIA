package dev.projeto.ia.KitchenAI.service;

import dev.projeto.ia.KitchenAI.model.FoodItem;
import dev.projeto.ia.KitchenAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }

    public FoodItem saveItem(FoodItem foodItem) {
        return repository.save(foodItem);
    }

        public List<FoodItem> itemsList() {
        return repository.findAll();
    }

        public FoodItem alterItem (Long id, FoodItem foodItem) {
        Optional<FoodItem> optionalFoodItem = repository.findById(id); //retorna o optional com objeto ou nulo.
        if (optionalFoodItem.isPresent()) {
            foodItem.setId(id);
            return repository.save(foodItem);
        }
        return null;
    }

        public FoodItem findById(Long id) {
        Optional<FoodItem> optionalFoodItem = repository.findById(id);
        if (optionalFoodItem.isPresent()) {
            return optionalFoodItem.get();
        }
        return null;
    }

        public void deleteItem(Long id){
        repository.deleteById(id);
    }

}
