package baseball;

import baseball.interfaces.controllers.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        gameController.playBall();
    }
}
