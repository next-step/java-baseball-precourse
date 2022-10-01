package baseball.domain;

import static baseball.domain.JudgmentType.*;

public class BaseballScore {
    private static final int STRIKE_COUNT_OF_WIN = 3;

    private final int strike;
    private final int ball;

    public BaseballScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isWin() {
        return strike == STRIKE_COUNT_OF_WIN;
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    private boolean isOnlyStrike() {
        return strike > 0 && ball == 0;
    }

    private boolean isOnlyBall() {
        return strike == 0 && ball > 0;
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return NOTHING.toString();
        }
        if (isOnlyStrike()) {
            return STRIKE.toString(strike);
        }
        if (isOnlyBall()) {
            return BALL.toString(ball);
        }
        return String.format("%s %s", BALL.toString(ball), STRIKE.toString(strike));
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
