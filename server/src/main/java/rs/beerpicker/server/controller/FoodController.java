package rs.beerpicker.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.beerpicker.server.model.Food;
import rs.beerpicker.server.service.abstraction.FoodService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/food")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @GetMapping(value = "/")
    public ResponseEntity<List<Food>> get() {
        HttpStatus status;
        List<Food> foodes = foodService.findAll();
        if (foodes == null) {
            status = HttpStatus.NOT_FOUND;
        } else if (foodes.size() == 0) {
            status = HttpStatus.NO_CONTENT;
        } else {
            status = HttpStatus.FOUND;
        }
        return new ResponseEntity<>(foodes, status);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Food> findById(@PathVariable Long id) {
        HttpStatus status;
        Food food = foodService.findById(id);
        if (food == null) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.FOUND;
        }
        return new ResponseEntity<>(food, status);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Food> create(@RequestBody Food food) {
        HttpStatus status;
        Food created = foodService.create(food);
        if (created == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(created, status);
    }
    @PostMapping(value = "/update")
    public ResponseEntity<Food> update(@RequestBody Food food) {
        HttpStatus status;
        Food updated = foodService.create(food);
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
        Boolean deleted = foodService.delete(id);
        if (!deleted) {
            status = HttpStatus.NOT_MODIFIED;
        } else {
            status = HttpStatus.GONE;
        }
        return new ResponseEntity<>(deleted, status);
    }
}
