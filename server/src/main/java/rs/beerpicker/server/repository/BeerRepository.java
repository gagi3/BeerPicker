package rs.beerpicker.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.model.BeerFlavour;
import rs.beerpicker.server.model.BeerStyle;
import rs.beerpicker.server.model.BeerType;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findByNameAndTypeAndStyle(String name, BeerType type, BeerStyle style);

    List<Beer> findByTypeAndStyle(BeerType type, BeerStyle style);

    List<Beer> findByStyle(BeerStyle style);

    List<Beer> findByType(BeerType type);

    List<Beer> findByFlavoursIn(List<BeerFlavour> flavour);

    List<Beer> findByNameAndTypeAndStyleAndFlavoursIn(String name, BeerType type, BeerStyle style, List<BeerFlavour> flavours);

    List<Beer> findByTypeAndStyleAndFlavoursIn(BeerType type, BeerStyle style, List<BeerFlavour> flavours);

    List<Beer> findByStyleAndFlavoursIn(BeerStyle style, List<BeerFlavour> flavours);

    List<Beer> findByTypeAndFlavoursIn(BeerType type, List<BeerFlavour> flavours);

    List<Beer> findByTypeAndStrengthGreaterThanEqual(BeerType type, Double strength);

    List<Beer> findByTypeAndStrengthLessThanEqual(BeerType type, Double strength);

    List<Beer> findByTypeAndStrengthBetween(BeerType type, Double low, Double top);

    List<Beer> findByTypeAndStyleAndStrengthGreaterThanEqual(BeerType type, BeerStyle style, Double strength);

    List<Beer> findByTypeAndStyleAndStrengthLessThanEqual(BeerType type, BeerStyle style, Double strength);

    List<Beer> findByTypeAndStyleAndStrengthBetween(BeerType type, BeerStyle style, Double low, Double top);
}
