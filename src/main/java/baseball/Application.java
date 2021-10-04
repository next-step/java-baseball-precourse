package baseball;

import baseball.controller.GameController;

import static baseball.AppConfig.getGameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = getGameController();
        gameController.start();
    }
}