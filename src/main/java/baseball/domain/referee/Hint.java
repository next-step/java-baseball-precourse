package baseball.domain.referee;

import java.util.Objects;

public class Hint {
    private int strike;
    private int ball;

    private Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Hint of(int strike, int ball) {
        return new Hint(strike, ball);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void updateStrikeCount(int strike) {
        this.strike = strike;
    }

    public void updateBallCount(int ball) {
        this.ball = ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hint hint = (Hint) o;
        return strike == hint.strike && ball == hint.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
