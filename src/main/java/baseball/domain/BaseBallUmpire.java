package baseball.domain;

public class BaseBallUmpire {
    private final int strike;
    private final int ball;

    public BaseBallUmpire(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isStrikeOut() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isNoneBall() {
        return ball == 0;
    }

    public boolean isNoneStrike() {
        return strike == 0;
    }
}
