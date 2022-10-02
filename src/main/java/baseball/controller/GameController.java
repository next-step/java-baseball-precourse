package baseball.controller;

import baseball.domain.GamePlay;

public class GameController {

    public static void start() {
        boolean nextGame = true;

        while (nextGame) {
            GamePlay gamePlay = new GamePlay();
            nextGame = gamePlay.play();
        }

    }
}
