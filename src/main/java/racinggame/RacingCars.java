package racinggame;

import java.util.Collections;
import java.util.List;

import nextstep.utils.Randoms;

public class RacingCars {
	public static final int MIN_RANDOM_NUMBER = 0;
	public static final int MAX_RANDOM_NUMBER = 9;

	private final List<RacingCar> racingCars;

	public RacingCars(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
	}

	public void race() {
		for (RacingCar racingCar : racingCars) {
			int number = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
			racingCar.race(number);
		}
	}

	public List<RacingCar> getRacingCars() {
		return Collections.unmodifiableList(racingCars);
	}
}
