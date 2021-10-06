package baseball.domain;

public class BaseBall {
    private int strike;
    private int ball;

    public BaseBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isNothing() {
        return (strike + ball) == 0;
    }

    public int strike() {
        return this.strike;
    }

    public int ball() {
        return this.ball;
    }

    public boolean isGameEnd() {
        return this.strike == 3 && this.ball == 0 && !this.isNothing();
    }
}
