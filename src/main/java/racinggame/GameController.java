package racinggame;

import java.util.List;

public class GameController {

    private final GameView gameView;
    private final GameService gameService;

    public GameController(GameView gameView, GameService gameService) {
        this.gameView = gameView;
        this.gameService = gameService;
    }

    public void run() {
        List<RacingCar> racingCars = generateRacingCars();
        int rounds = getRounds();
        System.out.println("rounds: " + rounds);
        // TODO implement rounds
    }

    private List<RacingCar> generateRacingCars() {
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
            } catch (NumberFormatException ex) {
                gameView.printErrorMessage("숫자 형식에 맞지 않습니다.");
            }
        }
    }
}
