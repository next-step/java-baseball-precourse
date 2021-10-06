package baseball.code;

import java.util.List;

public enum BallCount {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String ballCount;

    BallCount(String ballCount) {
        this.ballCount = ballCount;
    }

    public String getBallCount() {
        return this.ballCount;
    }

    public static String toString(List<Integer> ballCount) {
        int strike = ballCount.get(0);
        int ball = ballCount.get(1);

        if (strike != 0 && ball != 0) {
            return strikeString(strike) + " " + ballString(ball);
        }
        if (strike != 0) {
            return strikeString(strike);
        }
        if (ball != 0) {
            return ballString(ball);
        }

        return BallCount.NOTHING.getBallCount();
    }

    private static String strikeString(int strike) {
        return strike + BallCount.STRIKE.getBallCount();
    }

    private static String ballString(int ball) {
        return ball + BallCount.BALL.getBallCount();
    }
}
