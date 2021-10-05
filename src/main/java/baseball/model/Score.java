package baseball.model;

public class Score {
	private final int strikeCount;
	private final int ballCount;

	public Score(final int strikeCount, final int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public String getScoreMessage() {
		String strikeMessage = createScoreMessage("%d스트라이크 ", strikeCount);
		String ballMessage = createScoreMessage("%d볼", ballCount);
		return getNothingMessageIfNothing(strikeMessage + ballMessage);
	}

	private String getNothingMessageIfNothing(final String message) {
		if ("".equals(message)) {
			return "낫싱";
		}
		return message;
	}

	private String createScoreMessage(final String source, final int score) {
		if (score > 0) {
			return String.format(source, score);
		}
		return "";
	}
}
