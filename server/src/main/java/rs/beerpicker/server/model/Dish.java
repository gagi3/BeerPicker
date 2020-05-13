package rs.beerpicker.server.model;

import java.util.Set;

public class Dish {
    private Long id;
    private String name;
    private DishType type;
    private Set<Food> ingredients;
    private Set<String> descriptors;
    private Set<Preparation> preparation;
    private Integer saltinessIndex;
    private Integer spicinessIndex;
    private Integer sweetnessIndex;
    private Integer sournessIndex;
    private Integer bitternessIndex;
}
