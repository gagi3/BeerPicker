package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.Meal;

import java.util.List;

public interface MealService {
    List<Meal> findAll();

    Meal findById(Long id);

    Meal create(Meal meal);

    Meal update(Meal meal);

    Boolean delete(Long id);
}
