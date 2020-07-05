package rs.beerpicker.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.beerpicker.server.dto.Rule;
import rs.beerpicker.server.model.Meal;
import rs.beerpicker.server.service.abstraction.DroolsService;

@RestController
@RequestMapping(value = "/api/drools")
public class DroolsController {
    @Autowired
    private DroolsService droolsService;

//    @PostMapping(value = "/recommend-by-food")
//    public ResponseEntity<?> recommendByFood(@RequestBody Food food) {
//        Object beers = droolsService.recommendByFood(food);
//        return new ResponseEntity<>(beers, HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/recommend-by-dish")
//    public ResponseEntity<?> recommendByDish(@RequestBody Dish dish) {
//        Object beers = droolsService.recommendByDish(dish);
//        return new ResponseEntity<>(beers, HttpStatus.OK);
//    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Rule rule) {
        String response = droolsService.create(rule);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/recommend-by-meal")
    public ResponseEntity<?> recommendByMeal(@RequestBody Meal meal) {
        Object beers = droolsService.recommendByMeal(meal);
        return new ResponseEntity<>(beers, HttpStatus.OK);
    }
}
