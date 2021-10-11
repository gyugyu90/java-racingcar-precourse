package racinggame;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static final String COMMA = ",";

    public List<RacingCar> registerRacingCars(String source) {
        List<RacingCar> list = new ArrayList<>();
        for (String s : source.split(COMMA)) {
            list.add(new RacingCar(s));
        }

        return list;
    }
}
