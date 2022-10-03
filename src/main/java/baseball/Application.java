package baseball;

import baseball.config.GameConfig;
import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController game = GameConfig.baseballGame();
        game.start();
    }
}
