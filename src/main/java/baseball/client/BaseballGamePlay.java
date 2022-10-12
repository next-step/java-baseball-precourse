package baseball.client;

import baseball.controller.BaseballController;
import baseball.vo.GameResultStatus;

public class BaseballGamePlay {

    public static BaseballController baseballController = new BaseballController();

    public void startGame() {
        startBaseballGame();
        doBaseballGame();
        confirmRestartBaseballGame();
    }

    private void startBaseballGame() {
        baseballController.initRandomBaseballNumber();
    }

    private void doBaseballGame() {
        boolean isSameNumber;
        do {
            int inputAnyNumber = baseballController.inputAnyNumber();
            GameResultStatus gameResultStatus
                    = baseballController.checkGameRuleInputNumberAndRandomNumber(inputAnyNumber);
            baseballController.guideGameResult(gameResultStatus);
            isSameNumber = gameResultStatus.isSameNumber();
        } while (!isSameNumber);
    }

    private void confirmRestartBaseballGame() {
        boolean restartGame = baseballController.confirmRestartGame();
        if (restartGame) {
            startGame();
        }
    }

}
