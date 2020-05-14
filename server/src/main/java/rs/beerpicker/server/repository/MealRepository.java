package rs.beerpicker.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.beerpicker.server.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
