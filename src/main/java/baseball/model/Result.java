package baseball.model;

public class Result {
    private final int strike;
    private final int ball;

    Result(int strike, int ball) {
        if (strike < 0)
            throw new IllegalArgumentException("Strike should be positive number.");
        if (ball < 0)
            throw new IllegalArgumentException("Ball should be positive number.");
        if (strike + ball > 3)
            throw new IllegalArgumentException("Sum of strike and ball should be less than three.");

        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
