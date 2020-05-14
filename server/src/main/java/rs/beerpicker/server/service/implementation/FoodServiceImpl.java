package rs.beerpicker.server.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.beerpicker.server.model.Food;
import rs.beerpicker.server.repository.FoodRepository;
import rs.beerpicker.server.service.abstraction.FoodService;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food findById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    @Override
    public Food create(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food update(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Boolean delete(Long id) {
        foodRepository.deleteById(id);
        return true;
    }
}
