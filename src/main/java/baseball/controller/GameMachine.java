package baseball.controller;

import baseball.service.NumberBaseBallGame;

public class GameMachine {

    final private NumberBaseBallGame numberBaseBallGame;

    public GameMachine() {
        this.numberBaseBallGame = new NumberBaseBallGame();
    }

    public void runningBaseBallGame() {
        do {
            numberBaseBallGame.start();
        } while (numberBaseBallGame.end());

    }

}
