package baseball.domain;

import baseball.service.AnswerMaker;

public class BaseballGame {

    private final String answer;

    private BaseballGameScoreBoard result;

    public BaseballGame() {
        this.answer = AnswerMaker.make();
    }

    public BaseballGameScoreBoard deal(String input) {
        //!TODO need implement
        return null;
    }

    public boolean isDone() {
        return false;
    }
}
