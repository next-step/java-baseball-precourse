package domain;

public class Score {
	public static final int ANSWER_LENGTH = 3;

	private int strikeCount;
	private int ballCount;

	public void addStrikeCount() {
		this.strikeCount += 1;
	}

	public void addBallCount() {
		this.ballCount += 1;
	}

	public String generateScoreMessage() {
		if (strikeCount == 0 && ballCount == 0) {
			return "낫싱";
		}
		return strikeCount + "스트라이크 " + ballCount + "볼";
	}

	public boolean isFinished() {
		return strikeCount == ANSWER_LENGTH;
	}
}
