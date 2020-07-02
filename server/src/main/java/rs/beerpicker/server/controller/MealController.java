package rs.beerpicker.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.beerpicker.server.model.Meal;
import rs.beerpicker.server.service.abstraction.MealService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/meal")
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Meal>> get() {
        HttpStatus status;
        List<Meal> meals = mealService.findAll();
        if (meals == null) {
            status = HttpStatus.NOT_FOUND;
        } else if (meals.size() == 0) {
            status = HttpStatus.NO_CONTENT;
        } else {
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(meals, status);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Meal> findById(@PathVariable Long id) {
        HttpStatus status;
        Meal meal = mealService.findById(id);
        if (meal == null) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(meal, status);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Meal> create(@RequestBody Meal meal) {
        HttpStatus status;
        Meal created = mealService.create(meal);
        if (created == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(created, status);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Meal> update(@RequestBody Meal meal) {
        HttpStatus status;
        Meal updated = mealService.create(meal);
        if (updated == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            status = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<>(updated, status);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        HttpStatus status;
        Boolean deleted = mealService.delete(id);
        if (!deleted) {
            status = HttpStatus.NOT_MODIFIED;
        } else {
            status = HttpStatus.GONE;
        }
        return new ResponseEntity<>(deleted, status);
    }
}
