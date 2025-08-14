package dev.projeto.ia.KitchenAI.repository;

import dev.projeto.ia.KitchenAI.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {
}
