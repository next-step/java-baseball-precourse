package baseball;

public class GameResult {

	private int strike;
	private int ball;

	private void addStrike() {
		this.strike++;
	}

	private void addBall() {
		this.ball++;
	}

	public boolean isComplete() {
		return strike == 3;
	}

	public void recordScore(BallStatus ballStatus) {

		if (ballStatus == BallStatus.STRIKE) {
			addStrike();
		}

		if (ballStatus == BallStatus.BALL) {
			addBall();
		}
	}

	private boolean isNothing() {
		return strike == 0 && ball == 0;
	}

	private boolean hasBoth() {
		return strike > 0 && ball > 0;
	}

	private boolean hasOnlyStrike() {
		return strike > 0 && ball == 0;
	}

	private boolean hasOnlyBall() {
		return strike == 0 && ball > 0;
	}

	@Override
	public String toString() {

		if (hasBoth()) {
			return String.format("%d스트라이크 %d볼", strike, ball);
		}

		if (hasOnlyStrike()) {
			return String.format("%d스트라이크", strike);
		}

		if (hasOnlyBall()) {
			return String.format("%d볼", ball);
		}

		return "낫싱";
	}

}
