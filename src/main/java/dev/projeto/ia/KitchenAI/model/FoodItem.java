package dev.projeto.ia.KitchenAI.model;
import dev.projeto.ia.KitchenAI.enums.FoodCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Entity
@Table(name = "food_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private FoodCategory category;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "validity")
    private LocalDate validity;

    @Version
    private Long version;
}
