package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.Food;

public interface DroolsService {
    Object recommendByFood(Food food);
}
