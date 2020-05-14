package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.model.BeerStyle;
import rs.beerpicker.server.model.BeerType;

import java.util.List;

public interface BeerService {
    List<Beer> findAll();

    Beer findById(Long id);

    Beer create(Beer beer);

    Beer update(Beer beer);

    Boolean delete(Long id);

    List<Beer> findByNameAndTypeAndStyle(String name, BeerType type, BeerStyle style);
    List<Beer> findByTypeAndStyle(BeerType type, BeerStyle style);
    List<Beer> findByStyle(BeerStyle style);
    List<Beer> findByType(BeerType type);
}
