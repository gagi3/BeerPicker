package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.model.BeerFlavour;
import rs.beerpicker.server.model.BeerStyle;
import rs.beerpicker.server.model.BeerType;

import java.util.List;

public interface BeerService {
    List<Beer> findAll();

    Beer findById(Long id);

    Beer create(Beer beer);

    Beer update(Beer beer);

    List<Beer> filter(List<Beer> input, BeerType type, BeerStyle style, List<BeerFlavour> flavours);

    Boolean delete(Long id);

    List<Beer> findByNameAndTypeAndStyle(String name, BeerType type, BeerStyle style);

    List<Beer> findByTypeAndStyle(BeerType type, BeerStyle style);

    List<Beer> findByStyle(BeerStyle style);

    List<Beer> findByType(BeerType type);

    List<Beer> findByFlavours(List<BeerFlavour> flavours);

    List<Beer> findByNameAndTypeAndStyleAndFlavours(String name, BeerType type, BeerStyle style, List<BeerFlavour> flavours);

    List<Beer> findByTypeAndStyleAndFlavours(BeerType type, BeerStyle style, List<BeerFlavour> flavours);

    List<Beer> findByStyleAndFlavours(BeerStyle style, List<BeerFlavour> flavours);

    List<Beer> findByTypeAndFlavours(BeerType type, List<BeerFlavour> flavours);

    List<Beer> findByTypeAndStrengthGreaterThanEqual(BeerType type, Double strength);

    List<Beer> findByTypeAndStrengthLessThanEqual(BeerType type, Double strength);

    List<Beer> findByTypeAndStrengthBetween(BeerType type, Double low, Double top);

    List<Beer> findByTypeAndStyleAndStrengthGreaterThanEqual(BeerType type, BeerStyle style, Double strength);

    List<Beer> findByTypeAndStyleAndStrengthLessThanEqual(BeerType type, BeerStyle style, Double strength);

    List<Beer> findByTypeAndStyleAndStrengthBetween(BeerType type, BeerStyle style, Double low, Double top);
}
