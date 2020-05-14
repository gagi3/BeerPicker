package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> findAll();

    Food findById(Long id);

    Food create(Food beer);

    Food update(Food beer);

    Boolean delete(Long id);
}
