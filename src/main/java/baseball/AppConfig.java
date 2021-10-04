package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.service.GameServiceImpl;

public class AppConfig {

    private static GameService gameService;
    private static GameController gameController;

    private AppConfig() {
    }

    public static GameController getGameController() {
        if (gameController == null) {
            gameController = new GameController(getGameService());
        }
        return gameController;
    }

    public static GameService getGameService() {
        if (gameService == null) {
            gameService = new GameServiceImpl();
        }
        return gameService;
    }

}
