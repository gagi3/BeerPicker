package rs.beerpicker.server.service.implementation;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.model.Food;
import rs.beerpicker.server.service.abstraction.BeerService;
import rs.beerpicker.server.service.abstraction.DroolsService;

import java.util.ArrayList;
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
        System.out.println("===");
        System.out.println("Food name: " + food.getName() + ", group: " + food.getType().toString() + ".");
        System.out.println("Searching for the following type(s), style(s) and/or flavour(s): ");
        kieSession.insert(food);
        kieSession.getAgenda().getAgendaGroup("food").setFocus();
        kieSession.insert(this.beerService);
        System.out.println("Executed " + kieSession.fireAllRules() + " rule(s).");

        kieSession.destroy();
        List<Beer> beers = (ArrayList<Beer>) kieSession.getGlobal("beers");
        List<Beer> list = new ArrayList<>();
        for (Beer b : beers) {
            if (!list.contains(b)) {
                list.add(b);
            }
        }
        System.out.println("Got " + list.size() + " result(s).");
        return list;
    }
}
