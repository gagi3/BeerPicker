package rs.beerpicker.server.service.implementation;

import org.drools.compiler.lang.descr.RuleDescr;
import org.drools.compiler.rule.builder.RuleBuildContext;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.beerpicker.server.dto.Rule;
import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.model.Meal;
import rs.beerpicker.server.service.abstraction.BeerService;
import rs.beerpicker.server.service.abstraction.DroolsService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DroolsServiceImpl implements DroolsService {
    private final KieContainer kieContainer;
    @Autowired
    private BeerService beerService;

    @Autowired
    public DroolsServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

//    @Override
//    public Object recommendByFood(Food food) {
//        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
//        kieSession.setGlobal("beers", new ArrayList<Beer>());
//        List<Beer> beerList = beerService.findAll();
//        System.out.println("===");
//        System.out.println("Food name: " + food.getName() + ", group: " + food.getType().toString() + ".");
//        System.out.println("Searching for the following type(s), style(s) and/or flavour(s): ");
//        kieSession.insert(this.beerService);
//        kieSession.insert(food);
//        beerList.forEach(kieSession::insert);
//        kieSession.getAgenda().getAgendaGroup("food").setFocus();
//        System.out.println("Executed " + kieSession.fireAllRules() + " rule(s).");
//        List<Object> objects = new ArrayList<>();
//        kieSession.getQueryResults("getBeers").forEach(row -> objects.add(row.get("$beer")));
//        kieSession.destroy();
//        return objects;
//    }
//
//    @Override
//    public Object recommendByDish(Dish dish) {
//        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
//        kieSession.setGlobal("beers", new ArrayList<Beer>());
//        kieSession.setGlobal("recommendations", new ArrayList<Beer>());
//        List<Beer> beerList = new ArrayList<>();
//        System.out.println("===");
//        System.out.println("Dish name: " + dish.getName() + ", group: " + dish.getType().toString() + ".");
//        System.out.println("Searching for the following type(s), style(s) and/or flavour(s): ");
//        kieSession.insert(this.beerService);
////        beerList.forEach(kieSession::insert);
//        if (dish.getIngredients() != null) {
//            dish.getIngredients().forEach(food -> {
//                beerList.addAll((Collection<? extends Beer>) recommendByFood(food));
//            });
//        } else {
//            beerList.addAll(beerService.findAll());
//        }
//        beerList.forEach(kieSession::insert);
//        kieSession.insert(dish);
//        System.out.println("Executed " + kieSession.fireAllRules() + " rule(s).");
//        List<Object> objects = new ArrayList<>();
//        kieSession.getQueryResults("getBeers").forEach(row -> objects.add(row.get("$beer")));
//        kieSession.destroy();
//
//        return objects;
//    }

//    @Override
//    public Object recommendByMeal(Meal meal) {
//        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
//        kieSession.setGlobal("beers", new ArrayList<Beer>());
//        kieSession.setGlobal("recommendations", new ArrayList<Beer>());
//        List<Beer> beerList = new ArrayList<>();
//        System.out.println("===");
//        System.out.println("Dish name: " + meal.getName() + ", group: " + meal.getType().toString() + ".");
//        System.out.println("Searching for the following type(s), style(s) and/or flavour(s): ");
//        kieSession.insert(this.beerService);
//        if (meal.getDishes() != null) {
//            meal.getDishes().forEach(dish -> {
//                beerList.addAll((Collection<? extends Beer>) recommendByDish(dish));
//            });
//        } else {
//            beerList.addAll(beerService.findAll());
//        }
//        beerList.forEach(kieSession::insert);
//        kieSession.insert(meal);
//        System.out.println("Executed " + kieSession.fireAllRules() + " rule(s).");
//        List<Object> objects = new ArrayList<>();
//        kieSession.getQueryResults("getBeers").forEach(row -> objects.add(row.get("$beer")));
//        kieSession.destroy();
//
//        return objects;
//    }

    @Override
    public Object recommendByMeal(Meal meal) {
        KieSession kieSession = kieContainer.newKieSession("BeerPickerSession");
//        kieSession.setGlobal("beers", new ArrayList<Beer>());
//        kieSession.setGlobal("recommendations", new ArrayList<Beer>());
        System.out.println("===");
        System.out.println("Meal name: " + meal.getName() + ", group: " + meal.getType().toString() + ".");
        kieSession.insert(this.beerService);
//        if (meal.getDishes() != null) {
//            meal.getDishes().forEach(dish -> {
//                beerList.addAll((Collection<? extends Beer>) recommendByDish(dish));
//            });
//        } else {
        List<Beer> beerList = new ArrayList<>(beerService.findAll());
//        }
        beerList.forEach(kieSession::insert);
        kieSession.insert(meal);
        System.out.println("Executed " + kieSession.fireAllRules() + " rule(s).");
        List<Object> objects = new ArrayList<>();
        kieSession.getQueryResults("getRecommendations").forEach(row -> objects.add(row.get("$recommendation")));
        kieSession.destroy();

        return objects;
    }

    @Override
    public String create(Rule rule) {
        String output = "";
        output += "package drools;\n" +
                "import rs.beerpicker.server.model.*\n" +
                "import rs.beerpicker.server.dto.*\n" +
                "import rs.beerpicker.server.service.abstraction.*\n" +
                "import java.util.List\n" +
                "import java.util.ArrayList\n" +
                "import java.util.Arrays\n" +
                "dialect  \"mvel\"\n\n";
        output += "rule " + "\"" + rule.getName() + "\"\n";
        if (rule.getAgendaGroup() != null && !rule.getAgendaGroup().equals("")) {
            output += "agenda-group " + "\"" + rule.getAgendaGroup() + "\"\n";
        }
        if (rule.getSalience() != null) {
            output += "salience " + rule.getSalience() + "\n";
        }
        if (rule.getLockOnActive()) {
            output += "lock-on-active\n";
        }
        if (rule.getNoLoop()) {
            output += "no-loop\n";
        }
        output += "when\n";
        output += rule.getWhen() + "\n";
        output += "then\n";
        output += rule.getThen() + "\n";
        output += "end";
        writeToFile(output, rule.getName());
        return "Rule created successfully! Please wait until the next app restart for the changes to take place.";
    }

    private void writeToFile(String output, String name) {
        File file = new File("src/main/resources/drools/" + name + ".drl");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(output);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
