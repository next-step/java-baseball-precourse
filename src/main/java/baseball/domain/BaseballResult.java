package baseball.domain;

import java.util.Objects;

public class BaseballResult {

    private int strike;
    private int ball;

    public BaseballResult() {

    }

    public BaseballResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void save(BallHint ballHint) {
        if(ballHint.isStrike()) {
            strike++;
        }
        if(ballHint.isBall()) {
            ball++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballResult that = (BaseballResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
