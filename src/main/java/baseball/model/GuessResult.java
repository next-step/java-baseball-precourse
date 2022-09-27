package baseball.model;

public class GuessResult {

	private int ballCount;
	private int strikeCount;

	public GuessResult() {
	}

	public GuessResult(int ballCount, int strikeCount) {
		this.ballCount = ballCount;
		this.strikeCount = strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public void setStrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}
}
