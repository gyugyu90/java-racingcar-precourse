package racinggame;

public class GameController {

	private final GameView gameView;
	private final GameService gameService;

	public GameController(GameView gameView, GameService gameService) {
		this.gameView = gameView;
		this.gameService = gameService;
	}

	public void run() {
		generateRacingCars();
		getRounds();

		gameView.showResultHeader();

		GameResult gameResult = gameService.race();
		gameView.showRaceResult(gameResult);

		String winners = gameService.calculateWinners();
		gameView.showWinners(winners);
	}

	private void generateRacingCars() {
		boolean isReady = false;
		while (!isReady) {
			isReady = doGenerateRacingCars();
		}
	}

	private boolean doGenerateRacingCars() {
		try {
			String input = gameView.racingCarsForm();
			gameService.registerRacingCars(input);
			return true;
		} catch (IllegalArgumentException ex) {
			gameView.printErrorMessage(ex.getMessage());
			return false;
		}
	}

	private void getRounds() {
		boolean isReady = false;
		while (!isReady) {
			isReady = doGetRounds();
		}
	}

	private boolean doGetRounds() {
		try {
			String input = gameView.roundsForm();
			gameService.parseRounds(input);
			return true;
		} catch (IllegalArgumentException ex) {
			gameView.printErrorMessage(ex.getMessage());
			return false;
		}
	}
}
