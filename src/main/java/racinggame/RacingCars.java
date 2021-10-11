package racinggame;

import nextstep.utils.Randoms;

import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void race() {
        for (RacingCar racingCar : racingCars) {
            int number = Randoms.pickNumberInRange(0, 9);
            racingCar.race(number);
        }
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
