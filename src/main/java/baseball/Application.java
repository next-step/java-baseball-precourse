package baseball;

import baseball.controller.GameController;
import baseball.domain.GameStatus;

import static baseball.AppConfig.getGameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = getGameController();
        gameController.start(GameStatus.START);
    }
}