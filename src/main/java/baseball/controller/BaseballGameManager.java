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
        BaseballCount baseballCount = getUserInput();
        ResultBallCount resultBallCount = baseballReferee.getResultBallCount(answerNumber, baseballCount);
        baseballViewer.displayResult(resultBallCount);
    }

    public BaseballCount getUserInput() {
        String input = baseballViewer.getUserInput();
        return new BaseballCount(input);
    }
}
