package baseball.model;

public class Score {

	private final int strike;
	private final int ball;

	public Score(int strikeCount, int ballCount) {
		this.strike = strikeCount;
		this.ball = ballCount;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public boolean isNothing() {
		return this.strike == 0 && this.ball == 0;
	}

	public boolean isWin() {
		return this.strike == 3;
	}

}
