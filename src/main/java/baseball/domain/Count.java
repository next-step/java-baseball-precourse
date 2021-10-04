package baseball.domain;

public class Count {
    private final int ball;
    private final int strike;

    public Count(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
