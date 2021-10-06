package baseball.model;

import baseball.code.BallCountType;

public class BallCount {
    private final int strike;
    private final int ball;

    public BallCount(Builder builder) {
        this.strike = builder.strike;
        this.ball = builder.ball;
    }

    public String generateBallCountString() {
        if (this.strike != 0 && this.ball != 0) {
            return strikeString(this.strike) + " " + ballString(this.ball);
        }
        if (this.strike != 0) {
            return strikeString(this.strike);
        }
        if (this.ball != 0) {
            return ballString(this.ball);
        }

        return BallCountType.NOTHING.getBallCount();
    }

    private static String strikeString(int strike) {
        return strike + BallCountType.STRIKE.getBallCount();
    }

    private static String ballString(int ball) {
        return ball + BallCountType.BALL.getBallCount();
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public static class Builder {
        private int strike;
        private int ball;

        public BallCount.Builder strike(int strike) {
            this.strike = strike;
            return this;
        }

        public BallCount.Builder ball(int ball) {
            this.ball = ball;
            return this;
        }

        public BallCount build() {
            return new BallCount(this);
        }
    }
}
