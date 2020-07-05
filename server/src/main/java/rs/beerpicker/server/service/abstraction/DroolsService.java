package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.dto.Rule;
import rs.beerpicker.server.model.Meal;

public interface DroolsService {
//    Object recommendByFood(Food food);
//
//    Object recommendByDish(Dish dish);

    Object recommendByMeal(Meal meal);

    String create(Rule rule);
}
