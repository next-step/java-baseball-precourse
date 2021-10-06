package baseball.domain;

public class BaseballGameScoreBoard {

	private int strikeCount;

	private int ballCount;

	public BaseballGameScoreBoard(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public BaseballGameScoreBoard() {
		this(0, 0);
	}

	public BaseballGameScoreBoard update(BaseballGameScore score) {
		if (score.equals(BaseballGameScore.BALL)) {
			this.increaseBallCount();
		}

		if (score.equals(BaseballGameScore.STRIKE)) {
			this.increaseStrikeCount();
		}

		return this;
	}

	public BaseballGameScoreBoard increaseBallCount() {
		ballCount++;
		return this;
	}

	public BaseballGameScoreBoard increaseStrikeCount() {
		strikeCount++;
		return this;
	}

	public boolean isThreeStrikes() {
		return strikeCount == 3;
	}

	public boolean isNothing() {
		return getStrikeCount() == 0 && getBallCount() == 0;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}
}
