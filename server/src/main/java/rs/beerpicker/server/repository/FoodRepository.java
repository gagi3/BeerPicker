package rs.beerpicker.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
