package baseball;

import baseball.core.service.GameService;

public class Application {
    public static void main(String[] args) {

        GameService gameService = new GameService();
        gameService.startGame();

    }
}
