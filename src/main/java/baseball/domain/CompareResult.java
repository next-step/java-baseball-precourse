package baseball.domain;

public class CompareResult {

    private int strike;
    private int ball;

    private CompareResult() {}

    public CompareResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }

    public boolean isSuccess() {
        return this.strike == BaseballNumber.BASEBALL_SIZE;
    }
}
