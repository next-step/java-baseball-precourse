package baseball;

import baseball.configuration.AppConfig;
import baseball.controller.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        AppConfig appConfig = new AppConfig();
        BaseballGameController controller = appConfig.baseballGameController();

        controller.startNewGame();
    }
}
