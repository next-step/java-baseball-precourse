package baseball.controller;

import baseball.service.GameService;

public class GameController {
    private GameService gameService;

    public void run() {
        while (true) {
            gameService.playGame();
        }
    }

}
