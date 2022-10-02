package baseball.domain;

import baseball.etc.GameManager;

public class PlayResult {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(final BallStatus play) {
        if (play.isStrike()) {
            this.addStrike();
        }
        if (play.isBall()) {
            this.addBall();
        }
    }

    public boolean isNotGameOver() {
        return this.strike < GameManager.BALLS_SIZE;
    }

    public boolean isGameOver() {
        return this.strike == GameManager.BALLS_SIZE;
    }

    private void addStrike() {
        this.strike += 1;
    }

    private void addBall() {
        this.ball += 1;
    }

    public boolean isNotEmptyStrike() {
        return this.strike > 0;
    }

    public boolean isNotEmptyBall() {
        return this.ball > 0;
    }

    public boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }
}
