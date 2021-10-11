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
        generateRacingCars();
        int rounds = getRounds();

        gameView.showResultHeader();
        for (int i = 0; i < rounds; i++) {
            List<String> statuses = gameService.proceedRound();
            gameView.showRaceStatus(statuses);
        }

        String winners = gameService.calculateWinners();
        gameView.showWinners(winners);
    }

    private void generateRacingCars() {
        boolean generated = false;
        while(!generated) {
            generated = doGenerateRacingCars();
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

    private int getRounds() {
        while(true) { // TODO refactor this
            try {
                String input = gameView.roundsForm();
                return gameService.parseRounds(input);
            } catch (IllegalArgumentException ex) {
                gameView.printErrorMessage(ex.getMessage());
            }
        }
    }
}
