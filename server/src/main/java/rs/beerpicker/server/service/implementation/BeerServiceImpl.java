package rs.beerpicker.server.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.beerpicker.server.model.Beer;
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
}
