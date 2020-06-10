package rs.beerpicker.server.service.implementation;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.model.Dish;
import rs.beerpicker.server.model.Food;
import rs.beerpicker.server.model.Meal;
import rs.beerpicker.server.service.abstraction.BeerService;
import rs.beerpicker.server.service.abstraction.DroolsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DroolsServiceImpl implements DroolsService {
    private final KieContainer kieContainer;
    @Autowired
    private BeerService beerService;

    @Autowired
    public DroolsServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Override
    public Object recommendByFood(Food food) {
        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
        kieSession.setGlobal("beers", new ArrayList<Beer>());
        List<Beer> beerList = beerService.findAll();
        System.out.println("===");
        System.out.println("Food name: " + food.getName() + ", group: " + food.getType().toString() + ".");
        System.out.println("Searching for the following type(s), style(s) and/or flavour(s): ");
        kieSession.insert(this.beerService);
        kieSession.insert(food);
        beerList.forEach(kieSession::insert);
        kieSession.getAgenda().getAgendaGroup("food").setFocus();
        System.out.println("Executed " + kieSession.fireAllRules() + " rule(s).");
        List<Object> objects = new ArrayList<>();
        kieSession.getQueryResults("getBeers").forEach(row -> objects.add(row.get("$beer")));
        kieSession.destroy();
        return objects;
    }

    @Override
    public Object recommendByDish(Dish dish) {
        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
        kieSession.setGlobal("beers", new ArrayList<Beer>());
        kieSession.setGlobal("recommendations", new ArrayList<Beer>());
        List<Beer> beerList = new ArrayList<>();
        System.out.println("===");
        System.out.println("Dish name: " + dish.getName() + ", group: " + dish.getType().toString() + ".");
        System.out.println("Searching for the following type(s), style(s) and/or flavour(s): ");
        kieSession.insert(this.beerService);
//        beerList.forEach(kieSession::insert);
        if (dish.getIngredients() != null) {
            dish.getIngredients().forEach(food -> {
                beerList.addAll((Collection<? extends Beer>) recommendByFood(food));
            });
        } else {
            beerList.addAll(beerService.findAll());
        }
        beerList.forEach(kieSession::insert);
        kieSession.insert(dish);
        System.out.println("Executed " + kieSession.fireAllRules() + " rule(s).");
        List<Object> objects = new ArrayList<>();
        kieSession.getQueryResults("getBeers").forEach(row -> objects.add(row.get("$beer")));
        kieSession.destroy();

        return objects;
    }

    @Override
    public Object recommendByMeal(Meal meal) {
        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
        kieSession.setGlobal("beers", new ArrayList<Beer>());
        kieSession.setGlobal("recommendations", new ArrayList<Beer>());
        List<Beer> beerList = new ArrayList<>();
        System.out.println("===");
        System.out.println("Dish name: " + meal.getName() + ", group: " + meal.getType().toString() + ".");
        System.out.println("Searching for the following type(s), style(s) and/or flavour(s): ");
        kieSession.insert(this.beerService);
        if (meal.getDishes() != null) {
            meal.getDishes().forEach(dish -> {
                beerList.addAll((Collection<? extends Beer>) recommendByDish(dish));
            });
        } else {
            beerList.addAll(beerService.findAll());
        }
        beerList.forEach(kieSession::insert);
        kieSession.insert(meal);
        System.out.println("Executed " + kieSession.fireAllRules() + " rule(s).");
        List<Object> objects = new ArrayList<>();
        kieSession.getQueryResults("getBeers").forEach(row -> objects.add(row.get("$beer")));
        kieSession.destroy();

        return objects;
    }
}
