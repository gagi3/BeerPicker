package rs.beerpicker.server.model;

import java.util.Set;

public class Meal {
    private Long id;
    private String name;
    private MealType type;
    private Set<Dish> dishes;
}
