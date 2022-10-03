package baseball.domain;

import baseball.code.BallCountType;

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

	public BallCountType checkBallCountType(Ball ball) {
		if (this.isStrike(ball)) {
			return BallCountType.STRIKE;
		}
		if (this.isBall(ball)) {
			return BallCountType.BALL;
		}
		return BallCountType.NOTHING;
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
