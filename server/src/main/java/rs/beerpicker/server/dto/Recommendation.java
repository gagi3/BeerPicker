package rs.beerpicker.server.dto;

import rs.beerpicker.server.model.Beer;
import rs.beerpicker.server.model.BeerFlavour;
import rs.beerpicker.server.model.BeerStyle;
import rs.beerpicker.server.model.BeerType;

import java.util.List;

public class Recommendation {
    private BeerType type;
    private BeerStyle style;
    private List<BeerFlavour> flavours;
    private List<Beer> recommendations;
}
