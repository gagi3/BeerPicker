package rs.beerpicker.server.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.model.BeerFlavour;
import rs.beerpicker.server.model.BeerStyle;
import rs.beerpicker.server.model.BeerType;
import rs.beerpicker.server.repository.BeerRepository;
import rs.beerpicker.server.service.abstraction.BeerService;

import java.util.List;

@Service
public class BeerServiceImpl implements BeerService {
    @Autowired
    private BeerRepository beerRepository;

    @Override
    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    @Override
    public Beer findById(Long id) {
        return beerRepository.findById(id).orElse(null);
    }

    @Override
    public Beer create(Beer beer) {
        return beerRepository.save(beer);
    }

    @Override
    public Beer update(Beer beer) {
        return beerRepository.save(beer);
    }

    @Override
    public Boolean delete(Long id) {
        beerRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Beer> findByNameAndTypeAndStyle(String name, BeerType type, BeerStyle style) {
        return beerRepository.findByNameAndTypeAndStyle(name, type, style);
    }

    @Override
    public List<Beer> findByTypeAndStyle(BeerType type, BeerStyle style) {
        return beerRepository.findByTypeAndStyle(type, style);
    }

    @Override
    public List<Beer> findByStyle(BeerStyle style) {
        return beerRepository.findByStyle(style);
    }

    @Override
    public List<Beer> findByType(BeerType type) {
        return beerRepository.findByType(type);
    }

    @Override
    public List<Beer> findByFlavours(List<BeerFlavour> flavours) {
        return beerRepository.findByFlavoursIn(flavours);
    }

    @Override
    public List<Beer> findByNameAndTypeAndStyleAndFlavours(String name, BeerType type, BeerStyle style, List<BeerFlavour> flavours) {
        return beerRepository.findByNameAndTypeAndStyleAndFlavoursIn(name, type, style, flavours);
    }

    @Override
    public List<Beer> findByTypeAndStyleAndFlavours(BeerType type, BeerStyle style, List<BeerFlavour> flavours) {
        return beerRepository.findByTypeAndStyleAndFlavoursIn(type, style, flavours);
    }

    @Override
    public List<Beer> findByStyleAndFlavours(BeerStyle style, List<BeerFlavour> flavours) {
        return beerRepository.findByStyleAndFlavoursIn(style, flavours);
    }

    @Override
    public List<Beer> findByTypeAndFlavours(BeerType type, List<BeerFlavour> flavours) {
        return beerRepository.findByTypeAndFlavoursIn(type, flavours);
    }

    @Override
    public List<Beer> findByTypeAndStrengthGreaterThanEqual(BeerType type, Double strength) {
        return beerRepository.findByTypeAndStrengthGreaterThanEqual(type, strength);
    }

    @Override
    public List<Beer> findByTypeAndStrengthLessThanEqual(BeerType type, Double strength) {
        return beerRepository.findByTypeAndStrengthLessThanEqual(type, strength);
    }

    @Override
    public List<Beer> findByTypeAndStrengthBetween(BeerType type, Double low, Double top) {
        return beerRepository.findByTypeAndStrengthBetween(type, low, top);
    }

    @Override
    public List<Beer> findByTypeAndStyleAndStrengthGreaterThanEqual(BeerType type, BeerStyle style, Double strength) {
        return beerRepository.findByTypeAndStyleAndStrengthGreaterThanEqual(type, style, strength);
    }

    @Override
    public List<Beer> findByTypeAndStyleAndStrengthLessThanEqual(BeerType type, BeerStyle style, Double strength) {
        return beerRepository.findByTypeAndStyleAndStrengthLessThanEqual(type, style, strength);
    }

    @Override
    public List<Beer> findByTypeAndStyleAndStrengthBetween(BeerType type, BeerStyle style, Double low, Double top) {
        return beerRepository.findByTypeAndStyleAndStrengthBetween(type, style, low, top);
    }
}
