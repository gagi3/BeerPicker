package rs.beerpicker.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.beerpicker.server.model.Food;
import rs.beerpicker.server.service.abstraction.DroolsService;

@RestController
@RequestMapping(value = "/api/drools")
public class DroolsController {
    @Autowired
    private DroolsService droolsService;

    @PostMapping(value = "/recommend-by-food")
    public ResponseEntity<?> recommendByFood(@RequestBody Food food) {
        Object beers = droolsService.recommendByFood(food);
        return new ResponseEntity<>(beers, HttpStatus.OK);
    }
}
