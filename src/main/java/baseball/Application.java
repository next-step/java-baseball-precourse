package baseball;

import baseball.game.BaseballGame;
import baseball.game.GameManager;

public class Application {
    public static void main(String[] args) {

        BaseballGame baseballGame = new BaseballGame();
        GameManager gameManager = new GameManager(baseballGame);
        gameManager.run();

    }
}
