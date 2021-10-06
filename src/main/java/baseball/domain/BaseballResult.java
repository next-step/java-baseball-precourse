package baseball.domain;

import baseball.enums.GameMessage;
import baseball.veiw.ConsoleResponse;

import java.util.Objects;

public class BaseballResult {

    public static final int ALLSTRIKE = 3;
    private int strike;
    private int ball;

    public BaseballResult() {
    }

    public BaseballResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void save(BallHint ballHint) {
        if (ballHint.isStrike()) {
            strike++;
        }
        if (ballHint.isBall()) {
            ball++;
        }
    }

    public boolean allStrike() {
        return strike == ALLSTRIKE;
    }

    public void playResultPrint() {
        ConsoleResponse.printMessage(this.strike, GameMessage.STRIKE);
        ConsoleResponse.printMessage(this.ball, GameMessage.BALL);
        ConsoleResponse.printMessage();
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

    @Override
    public String toString() {
        return "BaseballResult{" +
                "strike=" + strike +
                ", ball=" + ball +
                '}';
    }
}
