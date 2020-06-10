package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.Dish;
import rs.beerpicker.server.model.Food;
import rs.beerpicker.server.model.Meal;

public interface DroolsService {
    Object recommendByFood(Food food);

    Object recommendByDish(Dish dish);

    Object recommendByMeal(Meal meal);
}
