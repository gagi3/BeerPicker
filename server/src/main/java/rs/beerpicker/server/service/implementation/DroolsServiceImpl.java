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
        System.out.println(food.getName());
        kieSession.insert(food);
        kieSession.getAgenda().getAgendaGroup("food").setFocus();
        kieSession.insert(this.beerService);
        System.out.println(kieSession.fireAllRules());

        kieSession.destroy();
        return kieSession.getGlobal("beers");
    }
}
