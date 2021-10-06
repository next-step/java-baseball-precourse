package baseball.model;

import baseball.code.BallCount;

public class Ball {
    private final int position;
    private final int value;

    public Ball(Builder builder) {
        this.position = builder.position;
        this.value = builder.value;
    }

    public int getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public Boolean isStrike(Ball ball) {
        return this.position == ball.getPosition() && this.value == ball.getValue();
    }

    public Boolean isBall(Ball ball) {
        return this.position != ball.getPosition() && this.value == ball.getValue();
    }

    public BallCount checkBallCountType(Ball ball) {
        if (this.isStrike(ball)) {
            return BallCount.STRIKE;
        }
        if (this.isBall(ball)) {
            return BallCount.BALL;
        }
        return BallCount.NOTHING;
    }

    public static class Builder {
        private int position;
        private int value;

        public Builder position(int position) {
            this.position = position;
            return this;
        }

        public Builder value(int value) {
            this.value = value;
            return this;
        }

        public Ball build() {
            return new Ball(this);
        }
    }
}
