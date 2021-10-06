package baseball.controller;

import baseball.model.BaseballCount;
import baseball.model.ResultBallCount;
import baseball.view.BaseballViewer;

public class BaseballGameManager {
    private final BaseballViewer baseballViewer;
    private final BaseballReferee baseballReferee;
    private final RandomNumberGenerator randomNumberGenerator;

    public BaseballGameManager(BaseballViewer baseballViewer, BaseballReferee baseballReferee, RandomNumberGenerator randomNumberGenerator) {
        this.baseballViewer = baseballViewer;
        this.baseballReferee = baseballReferee;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void play() {
        String answerNumber = randomNumberGenerator.generateRandomNumber();
        boolean isOut;
        do {
            BaseballCount baseballCount = getUserInput();
            ResultBallCount resultBallCount = baseballReferee.getResultBallCount(answerNumber, baseballCount);
            baseballViewer.displayResult(resultBallCount);
            isOut = resultBallCount.isOut();
        } while (!isOut);

        reGame();
    }

    public BaseballCount getUserInput() {
        String input = baseballViewer.getUserInput();
        return new BaseballCount(input);
    }

    public void reGame() {
        if(baseballViewer.isRestart()){
            play();
        }
    }
}
