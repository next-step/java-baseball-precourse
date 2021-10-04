package baseball.controller;

import baseball.AnswerResult;
import baseball.BaseBallGameManager;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseBallController {


    public static void startGame() {

        BaseBallGameManager baseBallGameManager = new BaseBallGameManager();

        while (!baseBallGameManager.isFinished()) {
            String userAnswer = InputView.enterAnswer();
            boolean isCollectAnswer = baseBallGameManager.checkUserAnswer(userAnswer);
            AnswerResult answerResult = baseBallGameManager.findAnswerResult(userAnswer);
            ResultView.answerResult(answerResult);
            retryGame(isCollectAnswer, baseBallGameManager);
        }
    }

    private static void retryGame(boolean isCollectAnswer, BaseBallGameManager baseBallGameManager) {
        String retryAnswer = null;
        if (!isCollectAnswer) {
            return;
        }
        retryAnswer = InputView.enterRetryAnswer();
        baseBallGameManager.prepareNextGame(retryAnswer);
    }
}
