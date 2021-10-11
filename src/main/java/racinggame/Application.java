package racinggame;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        GameService gameService = new GameService();
        GameController gameController = new GameController(gameView, gameService);

        gameController.run();
    }
}
