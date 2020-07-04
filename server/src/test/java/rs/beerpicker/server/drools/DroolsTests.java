package rs.beerpicker.server.drools;

//import org.junit.jupiter.api.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import rs.beerpicker.server.dto.Recommendation;
import rs.beerpicker.server.model.*;
import rs.beerpicker.server.service.abstraction.BeerService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(locations = "classpath:application.properties")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DroolsTests {
    @Autowired
    private BeerService beerService;

    @Test
    public void getBeersOK() {
        assertThat(beerService != null);
        assert beerService != null;
        assertThat(beerService.findAll() != null);
        assertThat(beerService.findAll().size() > 0);
    }

    @Test
    public void recommendByMealOK() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        Meal meal = new Meal();

        Dish d1 = new Dish();
        d1.setId(0L);
        d1.setBitternessIndex(0);
        d1.setSaltinessIndex(4);
        d1.setSournessIndex(0);
        d1.setSpicinessIndex(0);
        d1.setSweetnessIndex(1);
        d1.setCuisine(Cuisine.AMERICAN);
        d1.setName("steak with gorgonzola sauce");
        d1.setType(DishType.MAIN);
        d1.setPreparation(List.of(Preparation.FRYING));
        Dish d2 = new Dish();
        d2.setId(1L);
        d2.setBitternessIndex(0);
        d2.setSaltinessIndex(1);
        d2.setSournessIndex(0);
        d2.setSpicinessIndex(0);
        d2.setSweetnessIndex(4);
        d2.setCuisine(Cuisine.FRENCH);
        d2.setName("dark chocolate croissant");
        d2.setType(DishType.DESSERT);
        d2.setPreparation(List.of(Preparation.BAKING));

        Food f1 = new Food();
        f1.setId(0L);
        f1.setName("steak");
        f1.setType(FoodType.MEAT);
        Food f2 = new Food();
        f2.setId(0L);
        f2.setName("gorgonzola");
        f2.setType(FoodType.CHEESE);
        d1.setIngredients(List.of(f1, f2));
        Food f3 = new Food();
        f3.setId(0L);
        f3.setName("dark chocolate");
        f3.setType(FoodType.CHOCOLATE);
        Food f4 = new Food();
        f4.setId(0L);
        f4.setName("croissant");
        f4.setType(FoodType.DOUGH);
        d1.setIngredients(List.of(f3, f4));

        meal.setId(0L);
        meal.setName("steak with gorgonzola sauce and dark chocolate croissant");
        meal.setType(MealType.LUNCH);
        meal.setDishes(List.of(d1, d2));

        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
        List<Beer> beerList = new ArrayList<>(beerService.findAll());
        beerList.forEach(kieSession::insert);
        kieSession.insert(meal);
        Integer fired = kieSession.fireAllRules();
        List<Object> objects = new ArrayList<>();
        kieSession.getQueryResults("getRecommendations").forEach(row -> objects.add(row.get("$recommendation")));
        kieSession.destroy();

        assertThat(fired != 0);
        assertThat(objects.size() >= 1);
        assertThat(objects.get(0) instanceof Recommendation);
    }

    @Test
    public void recommendByMealBadInput() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        Meal meal = new Meal();

        Dish d1 = new Dish();
        d1.setId(0L);
        d1.setBitternessIndex(0);
        d1.setSaltinessIndex(0);
        d1.setSournessIndex(0);
        d1.setSpicinessIndex(0);
        d1.setSweetnessIndex(0);
        d1.setCuisine(Cuisine.ITALIAN_AMERICAN);
        d1.setName("steak with gorgonzola sauce");
        d1.setType(DishType.MAIN);
        Dish d2 = new Dish();
        d2.setId(1L);
        d2.setBitternessIndex(0);
        d2.setSaltinessIndex(0);
        d2.setSournessIndex(0);
        d2.setSpicinessIndex(0);
        d2.setSweetnessIndex(0);
        d2.setCuisine(Cuisine.GREEK);
        d2.setName("xxxxxxxx");

        Food f1 = new Food();
        f1.setId(0L);
        f1.setName("xxxxx");
        f1.setType(FoodType.MEAT);
        Food f2 = new Food();
        f2.setId(0L);
        f2.setName("xxxxxx");
        f2.setType(FoodType.CHEESE);
        d1.setIngredients(List.of(f1, f2));
        Food f3 = new Food();
        f3.setId(0L);
        f3.setName("xxxxx");
        f3.setType(FoodType.CHOCOLATE);
        Food f4 = new Food();
        f4.setId(0L);
        f4.setName("xxx");
        f4.setType(FoodType.DOUGH);
        d1.setIngredients(List.of(f3, f4));

        meal.setId(0L);
        meal.setName("steak with gorgonzola sauce and dark chocolate croissant");
        meal.setType(MealType.LUNCH);
        meal.setDishes(List.of(d1, d2));

        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
        List<Beer> beerList = new ArrayList<>(beerService.findAll());
        beerList.forEach(kieSession::insert);
        kieSession.insert(meal);
        Integer fired = kieSession.fireAllRules();
        List<Object> objects = new ArrayList<>();
        kieSession.getQueryResults("getRecommendations").forEach(row -> objects.add(row.get("$recommendation")));
        kieSession.destroy();

        assertThat(fired == 0);
        assertThat(objects.size() == 0);
    }

    @Test
    public void recommendByMealMealNotInserted() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();


        Meal meal = new Meal();

        Dish d1 = new Dish();
        d1.setId(0L);
        d1.setBitternessIndex(0);
        d1.setSaltinessIndex(4);
        d1.setSournessIndex(0);
        d1.setSpicinessIndex(0);
        d1.setSweetnessIndex(1);
        d1.setCuisine(Cuisine.AMERICAN);
        d1.setName("steak with gorgonzola sauce");
        d1.setType(DishType.MAIN);
        d1.setPreparation(List.of(Preparation.FRYING));
        Dish d2 = new Dish();
        d2.setId(1L);
        d2.setBitternessIndex(0);
        d2.setSaltinessIndex(1);
        d2.setSournessIndex(0);
        d2.setSpicinessIndex(0);
        d2.setSweetnessIndex(4);
        d2.setCuisine(Cuisine.FRENCH);
        d2.setName("dark chocolate croissant");
        d2.setType(DishType.DESSERT);
        d2.setPreparation(List.of(Preparation.BAKING));

        Food f1 = new Food();
        f1.setId(0L);
        f1.setName("steak");
        f1.setType(FoodType.MEAT);
        Food f2 = new Food();
        f2.setId(0L);
        f2.setName("gorgonzola");
        f2.setType(FoodType.CHEESE);
        d1.setIngredients(List.of(f1, f2));
        Food f3 = new Food();
        f3.setId(0L);
        f3.setName("dark chocolate");
        f3.setType(FoodType.CHOCOLATE);
        Food f4 = new Food();
        f4.setId(0L);
        f4.setName("croissant");
        f4.setType(FoodType.DOUGH);
        d1.setIngredients(List.of(f3, f4));

        meal.setId(0L);
        meal.setName("steak with gorgonzola sauce and dark chocolate croissant");
        meal.setType(MealType.LUNCH);
        meal.setDishes(List.of(d1, d2));

        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
        List<Beer> beerList = new ArrayList<>(beerService.findAll());
        beerList.forEach(kieSession::insert);
        Integer fired = kieSession.fireAllRules();
        List<Object> objects = new ArrayList<>();
        kieSession.getQueryResults("getRecommendations").forEach(row -> objects.add(row.get("$recommendation")));
        kieSession.destroy();

        assertThat(fired == 0);
        assertThat(objects.size() == 0);
    }

    @Test
    public void recommendByMealBeerNotInserted() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();


        Meal meal = new Meal();

        Dish d1 = new Dish();
        d1.setId(0L);
        d1.setBitternessIndex(0);
        d1.setSaltinessIndex(4);
        d1.setSournessIndex(0);
        d1.setSpicinessIndex(0);
        d1.setSweetnessIndex(1);
        d1.setCuisine(Cuisine.AMERICAN);
        d1.setName("steak with gorgonzola sauce");
        d1.setType(DishType.MAIN);
        d1.setPreparation(List.of(Preparation.FRYING));
        Dish d2 = new Dish();
        d2.setId(1L);
        d2.setBitternessIndex(0);
        d2.setSaltinessIndex(1);
        d2.setSournessIndex(0);
        d2.setSpicinessIndex(0);
        d2.setSweetnessIndex(4);
        d2.setCuisine(Cuisine.FRENCH);
        d2.setName("dark chocolate croissant");
        d2.setType(DishType.DESSERT);
        d2.setPreparation(List.of(Preparation.BAKING));

        Food f1 = new Food();
        f1.setId(0L);
        f1.setName("steak");
        f1.setType(FoodType.MEAT);
        Food f2 = new Food();
        f2.setId(0L);
        f2.setName("gorgonzola");
        f2.setType(FoodType.CHEESE);
        d1.setIngredients(List.of(f1, f2));
        Food f3 = new Food();
        f3.setId(0L);
        f3.setName("dark chocolate");
        f3.setType(FoodType.CHOCOLATE);
        Food f4 = new Food();
        f4.setId(0L);
        f4.setName("croissant");
        f4.setType(FoodType.DOUGH);
        d1.setIngredients(List.of(f3, f4));

        meal.setId(0L);
        meal.setName("steak with gorgonzola sauce and dark chocolate croissant");
        meal.setType(MealType.LUNCH);
        meal.setDishes(List.of(d1, d2));
        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
        kieSession.insert(meal);
        Integer fired = kieSession.fireAllRules();
        List<Object> objects = new ArrayList<>();
        kieSession.getQueryResults("getRecommendations").forEach(row -> objects.add(row.get("$recommendation")));
        kieSession.destroy();

        assertThat(fired == 0);
        assertThat(objects.size() == 0);
    }

    @Test(expected = NullPointerException.class)
    public void recommendByMealBadSession() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();


        Meal meal = new Meal();

        Dish d1 = new Dish();
        d1.setId(0L);
        d1.setBitternessIndex(0);
        d1.setSaltinessIndex(4);
        d1.setSournessIndex(0);
        d1.setSpicinessIndex(0);
        d1.setSweetnessIndex(1);
        d1.setCuisine(Cuisine.AMERICAN);
        d1.setName("steak with gorgonzola sauce");
        d1.setType(DishType.MAIN);
        d1.setPreparation(List.of(Preparation.FRYING));
        Dish d2 = new Dish();
        d2.setId(1L);
        d2.setBitternessIndex(0);
        d2.setSaltinessIndex(1);
        d2.setSournessIndex(0);
        d2.setSpicinessIndex(0);
        d2.setSweetnessIndex(4);
        d2.setCuisine(Cuisine.FRENCH);
        d2.setName("dark chocolate croissant");
        d2.setType(DishType.DESSERT);
        d2.setPreparation(List.of(Preparation.BAKING));

        Food f1 = new Food();
        f1.setId(0L);
        f1.setName("steak");
        f1.setType(FoodType.MEAT);
        Food f2 = new Food();
        f2.setId(0L);
        f2.setName("gorgonzola");
        f2.setType(FoodType.CHEESE);
        d1.setIngredients(List.of(f1, f2));
        Food f3 = new Food();
        f3.setId(0L);
        f3.setName("dark chocolate");
        f3.setType(FoodType.CHOCOLATE);
        Food f4 = new Food();
        f4.setId(0L);
        f4.setName("croissant");
        f4.setType(FoodType.DOUGH);
        d1.setIngredients(List.of(f3, f4));

        meal.setId(0L);
        meal.setName("steak with gorgonzola sauce and dark chocolate croissant");
        meal.setType(MealType.LUNCH);
        meal.setDishes(List.of(d1, d2));
        KieSession kieSession = kieContainer.newKieSession("xSession");
        List<Beer> beerList = new ArrayList<>(beerService.findAll());
        beerList.forEach(kieSession::insert);
        kieSession.insert(meal);
        Integer fired = kieSession.fireAllRules();
        List<Object> objects = new ArrayList<>();
        kieSession.getQueryResults("getRecommendations").forEach(row -> objects.add(row.get("$recommendation")));
        kieSession.destroy();
    }
}
