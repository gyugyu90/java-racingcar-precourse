package racinggame;

import java.util.Collections;
import java.util.List;

public class GameResult {
	private final List<GameRound> rounds;

	public GameResult(List<GameRound> rounds) {
		this.rounds = rounds;
	}

	public List<GameRound> getRounds() {
		return Collections.unmodifiableList(rounds);
	}
}
