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

    List<Beer> findByFlavours(List<BeerFlavour> flavour);

    List<Beer> findByNameAndTypeAndStyleAndFlavours(String name, BeerType type, BeerStyle style, List<BeerFlavour> flavours);

    List<Beer> findByTypeAndStyleAndFlavours(BeerType type, BeerStyle style, List<BeerFlavour> flavours);

    List<Beer> findByStyleAndFlavours(BeerStyle style, List<BeerFlavour> flavours);

    List<Beer> findByTypeAndFlavours(BeerType type, List<BeerFlavour> flavours);
}
