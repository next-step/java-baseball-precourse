package baseball.domain;

public class CompareResult {
    private final int ball;
    private final int strike;

    public CompareResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }
}
