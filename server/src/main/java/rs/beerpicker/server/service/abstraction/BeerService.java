package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.Beer;

import java.util.List;

public interface BeerService {
    List<Beer> findAll();

    Beer findById(Long id);

    Beer create(Beer beer);

    Beer update(Beer beer);

    Boolean delete(Long id);
}
