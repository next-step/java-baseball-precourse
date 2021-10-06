package baseball;

import baseball.controller.GameController;
import baseball.domain.GameStatus;
import baseball.service.GameService;
import baseball.service.GameServiceImpl;

/**
 * Application 초기 설정을 관리하는 클래스
 */
public class AppConfig {

    private static GameService gameService;
    private static GameController gameController;
    private static GameStatus gameStatus;

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

    public static GameStatus getGameStatus() {
        if (gameStatus == null) {
            gameStatus = GameStatus.START;
        }
        return gameStatus;
    }

    public static void setGameStatusEnd() {
        gameStatus = GameStatus.END;
    }

    public static void setGameStatusStart() {
        gameStatus = GameStatus.START;
    }
}
