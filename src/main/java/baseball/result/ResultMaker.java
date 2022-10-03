package baseball.result;

import baseball.constants.Condition;
import baseball.result.bean.Result;

public class ResultMaker {
    private Counter counter;
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
        this.counter = result.getCounter();
        result.setBallCount(this.decisionBallCount());
        result.setStrikeCount(this.decisionStrikeCount());
        result.setNothing(this.decisionNothing());
        result.setGameOver(this.declareGameOver());
    }

    private int decisionBallCount() {
        return this.counter.containsDigitNumberCount() - this.counter.equalDigitNumberCount();
    }

    private int decisionStrikeCount() {
        return this.counter.equalDigitNumberCount();
    }

    private boolean decisionNothing() {
        return this.counter.containsDigitNumberCount() == 0;
    }

    private boolean declareGameOver() {
        return this.getResult().getStrikeCount() == Condition.MAX_STRIKE_COUNT;
    }
}
