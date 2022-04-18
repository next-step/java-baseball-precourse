package baseball;

public class Judgement {
	private final int strikeCount;
	private final int ballCount;
	private final int nothingCount;

	public Judgement(int strikeCount, int ballCount, int nothingCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
		this.nothingCount = nothingCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public int getNothingCount() {
		return nothingCount;
	}
}
