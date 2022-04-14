package baseball.balls;

import java.util.Map;

public class PlayResult {

    public static final int GAME_OVER_STRIKE_COUNT = 3;
    private final int strike;
    private final int ball;
    private final boolean isGameOver;

    public PlayResult(final Map<BallStatus, Integer> statusMap) {
        this.strike = statusMap.getOrDefault(BallStatus.STRIKE, 0);
        this.ball = statusMap.getOrDefault(BallStatus.BALL, 0);
        this.isGameOver = (strike == GAME_OVER_STRIKE_COUNT);
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public boolean isGameOver() {
        return this.isGameOver;
    }
}
