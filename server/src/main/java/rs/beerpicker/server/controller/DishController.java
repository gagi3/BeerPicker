package rs.beerpicker.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.beerpicker.server.model.Dish;
import rs.beerpicker.server.service.abstraction.DishService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dish")
public class DishController {
    @Autowired
    private DishService dishService;
    @GetMapping(value = "/")
    public ResponseEntity<List<Dish>> get() {
        HttpStatus status;
        List<Dish> dishes = dishService.findAll();
        if (dishes == null) {
            status = HttpStatus.NOT_FOUND;
        } else if (dishes.size() == 0) {
            status = HttpStatus.NO_CONTENT;
        } else {
            status = HttpStatus.FOUND;
        }
        return new ResponseEntity<>(dishes, status);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Dish> findById(@PathVariable Long id) {
        HttpStatus status;
        Dish dish = dishService.findById(id);
        if (dish == null) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.FOUND;
        }
        return new ResponseEntity<>(dish, status);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Dish> create(@RequestBody Dish dish) {
        HttpStatus status;
        Dish created = dishService.create(dish);
        if (created == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(created, status);
    }
    @PostMapping(value = "/update")
    public ResponseEntity<Dish> update(@RequestBody Dish dish) {
        HttpStatus status;
        Dish updated = dishService.create(dish);
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
        Boolean deleted = dishService.delete(id);
        if (!deleted) {
            status = HttpStatus.NOT_MODIFIED;
        } else {
            status = HttpStatus.GONE;
        }
        return new ResponseEntity<>(deleted, status);
    }
}
