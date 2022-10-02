package baseball.domain.result;

import java.util.List;

public class Result {

    private final int strike;
    private final int ball;

    private Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Result from(List<Score> content) {
        int strike = 0;
        int ball = 0;
        for (Score score : content) {
            strike = countStrike(strike, score);
            ball = countBall(ball, score);
        }
        return new Result(strike, ball);
    }

    private static int countBall(int ball, Score score) {
        if (score.isBall()) {
            ball++;
        }
        return ball;
    }

    private static int countStrike(int strike, Score score) {
        if (score.isStrike()) {
            strike++;
        }
        return strike;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isVictory() {
        return strike == 3;
    }

    public boolean hasStrike() {
        return strike > 0;
    }

    public boolean hasBall() {
        return ball > 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}