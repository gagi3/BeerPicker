package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> findAll();

    Food findById(Long id);

    Food create(Food food);

    Food update(Food food);

    Boolean delete(Long id);
}
