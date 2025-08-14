package dev.projeto.ia.KitchenAI.service;

import dev.projeto.ia.KitchenAI.model.FoodItem;
import dev.projeto.ia.KitchenAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    private final FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }

    //salvar itens
    public FoodItem saveItem(FoodItem foodItem) {
        return repository.save(foodItem);
    }

    //listar itens
    public List<FoodItem> ItemsList() {
        return repository.findAll();
    }

}
