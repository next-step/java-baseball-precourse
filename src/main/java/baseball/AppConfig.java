package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.service.GameServiceImpl;

public class AppConfig {

    private static final GameService gameService = new GameServiceImpl();
    private static final GameController gameController = new GameController(gameService);

    private AppConfig() {
    }

    public static GameController getGameController() {
        return gameController;
    }

    public static GameService getGameService() {
        return gameService;
    }

}
