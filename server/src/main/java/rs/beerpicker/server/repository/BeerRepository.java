package rs.beerpicker.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.beerpicker.server.model.Beer;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}
