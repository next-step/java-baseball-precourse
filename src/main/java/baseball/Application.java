package baseball;

import baseball.game.domain.Game;
import baseball.game.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController.run();
    }

}
