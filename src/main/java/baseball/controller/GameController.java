package baseball.controller;

import baseball.domain.GameStatus;
import baseball.service.GameService;

import static baseball.domain.PickNumbers.makePickNumbers;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /* 싱글톤 테스트용 */
    public GameService getGameService() {
        return gameService;
    }

    public void start(GameStatus gameStatus) {
        System.out.println("==========[ New Game ]==========");
        makePickNumbers();
    }
}
