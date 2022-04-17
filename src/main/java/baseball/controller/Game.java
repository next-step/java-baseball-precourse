package baseball.controller;

import baseball.domain.BaseBall;
import baseball.domain.CompareResult;
import baseball.view.GameView;
import baseball.view.InputReader.ReGameAnswer;

public class Game {
    private final GameView gameView;

    public Game(GameView gameView) {
        this.gameView = gameView;
    }

    public void play() {
        CompareResult compareResult;
        BaseBall computerBall = BaseBall.generateComputerBall();
        do {
            BaseBall userBall = new BaseBall(gameView.inputUserNumber());
            compareResult = computerBall.compare(userBall);
            gameView.showCompareResult(compareResult);
        } while (!compareResult.isSuccess());

        if (gameView.askReGame() == ReGameAnswer.ReGame) {
            play();
        }
    }
}
