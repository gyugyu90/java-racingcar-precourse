package racinggame;

public class GameController {

    private final GameView gameView;
    private final GameService gameService;

    public GameController(GameView gameView, GameService gameService) {
        this.gameView = gameView;
        this.gameService = gameService;
    }

    public void run() {
        RacingCars racingCars = generateRacingCars();
        int rounds = getRounds();

        gameView.showResultHeader();
        for (int i = 0; i < rounds; i++) {
            gameService.proceedRound(racingCars);
            gameView.showRaceStatus(racingCars);
        }

        String winners = gameService.calculateWinners(racingCars);
        gameView.showWinners(winners);
        System.out.println("racingCars: " + racingCars.getRacingCars());
    }

    private RacingCars generateRacingCars() {
        while(true) {
            try {
                String input = gameView.racingCarsForm();
                return gameService.registerRacingCars(input);
            } catch (IllegalArgumentException ex) {
                gameView.printErrorMessage(ex.getMessage());
            }
        }
    }

    private int getRounds() {
        while(true) {
            try {
                String input = gameView.roundsForm();
                return Integer.parseInt(input);
            } catch (IllegalArgumentException ex) {
                gameView.printErrorMessage(ex.getMessage());
            }
        }
    }
}
