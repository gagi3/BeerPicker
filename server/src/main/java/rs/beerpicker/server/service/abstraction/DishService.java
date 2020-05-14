package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> findAll();

    Dish findById(Long id);

    Dish create(Dish beer);

    Dish update(Dish beer);

    Boolean delete(Long id);
}
