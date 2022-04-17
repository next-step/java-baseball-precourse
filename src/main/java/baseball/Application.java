package baseball;

import baseball.answer.NumberStrategy;
import baseball.answer.RandomNumberStrategy;
import baseball.game.GameController;
import baseball.game.GameService;
import baseball.game.GameServiceImpl;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();
        NumberStrategy numberStrategy = new RandomNumberStrategy();
        GameController gameController = new GameController(gameService, numberStrategy);
        gameController.gameStart();
    }
}
