package racinggame;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    public List<RacingCar> registerRacingCars(String source) {
        List<RacingCar> list = new ArrayList<>();
        for (String s : source.split(",")) {
            list.add(new RacingCar(s));
        }

        return list;
    }
}
