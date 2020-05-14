package rs.beerpicker.server.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.beerpicker.server.model.Meal;
import rs.beerpicker.server.repository.MealRepository;
import rs.beerpicker.server.service.abstraction.MealService;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {
    @Autowired
    private MealRepository mealRepository;
    @Override
    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    @Override
    public Meal findById(Long id) {
        return mealRepository.findById(id).orElse(null);
    }

    @Override
    public Meal create(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Meal update(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Boolean delete(Long id) {
        mealRepository.deleteById(id);
        return true;
    }
}
