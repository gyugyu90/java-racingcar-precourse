package racinggame;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WinnerCalculator {

	private final Set<String> winners = new HashSet<>();

	private int highestScore;

	public void evaluate(RacingCar racingCar) {
		if (racingCar.getProgress() > highestScore) {
			highestScore = racingCar.getProgress();
			winners.clear();
			winners.add(racingCar.getName());
		}

		if (racingCar.getProgress() == highestScore) {
			winners.add(racingCar.getName());
		}
	}

	public Set<String> getWinners() {
		return Collections.unmodifiableSet(winners);
	}

}
