package baseball.model;

import java.util.StringJoiner;

public class Score {
	private static final String MESSAGE_DELIMITER = " ";

	private final int strikeCount;
	private final int ballCount;

	public Score(final int strikeCount, final int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public String getScoreMessage() {
		StringJoiner stringJoiner = new StringJoiner(MESSAGE_DELIMITER);
		stringJoiner.add(createScoreMessage("%d스트라이크", strikeCount));
		stringJoiner.add(createScoreMessage("%d볼", ballCount));
		return getNothingMessageIfNothing(stringJoiner.toString());
	}

	private String getNothingMessageIfNothing(final String message) {
		if (MESSAGE_DELIMITER.equals(message)) {
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
