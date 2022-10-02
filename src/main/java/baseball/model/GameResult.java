package baseball.model;

import java.util.Objects;

public class GameResult {
    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static GameResult init() {
        return new GameResult(0, 0);
    }

    public void addJudgeResult(final JudgeResult judgeResult) {
        if (judgeResult.isStrike()) {
            strike++;
            return;
        }
        if (judgeResult.isBall()) {
            ball++;
        }
    }

    public boolean hasBall() {
        return ball > 0;
    }

    public boolean hasStrike() {
        return strike > 0;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isGameOver() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResult that = (GameResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
