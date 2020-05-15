package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.model.Food;

import java.util.List;

public interface DroolsService {
    Object recommendByFood(Food food);
}
