package rs.beerpicker.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.service.abstraction.BeerService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/beer")
public class BeerController {
    @Autowired
    private BeerService beerService;
    @GetMapping(value = "/")
    public ResponseEntity<List<Beer>> get() {
        HttpStatus status;
        List<Beer> beers = beerService.findAll();
        if (beers == null) {
            status = HttpStatus.NOT_FOUND;
        } else if (beers.size() == 0) {
            status = HttpStatus.NO_CONTENT;
        } else {
            status = HttpStatus.FOUND;
        }
        return new ResponseEntity<>(beers, status);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Beer> findById(@PathVariable Long id) {
        HttpStatus status;
        Beer beer = beerService.findById(id);
        if (beer == null) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.FOUND;
        }
        return new ResponseEntity<>(beer, status);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Beer> create(@RequestBody Beer beer) {
        HttpStatus status;
        Beer created = beerService.create(beer);
        if (created == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(created, status);
    }
    @PostMapping(value = "/update")
    public ResponseEntity<Beer> update(@RequestBody Beer beer) {
        HttpStatus status;
        Beer updated = beerService.create(beer);
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
        Boolean deleted = beerService.delete(id);
        if (!deleted) {
            status = HttpStatus.NOT_MODIFIED;
        } else {
            status = HttpStatus.GONE;
        }
        return new ResponseEntity<>(deleted, status);
    }
}
