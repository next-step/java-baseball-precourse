package baseball.model;

public class PlayResult {
	private int strike;
	private int ball;

	public void report(BallStatus ballStatus) {
		if (ballStatus == BallStatus.STRIKE) {
			this.strike++;
		} else if (ballStatus == BallStatus.BALL) {
			this.ball++;
		}
	}

	public boolean isGameEnd() {
		return this.strike == 3;
	}

	public boolean isNothing() {
		return this.strike == 0 && this.ball == 0;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
