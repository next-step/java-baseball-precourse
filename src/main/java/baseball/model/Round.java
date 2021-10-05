package baseball.model;

import java.util.List;

public class Round {
	private final List<Integer> numbers;
	private Score score;

	public Score getScore() {
		return score;
	}

	public Round(final Computer computer, final List<Integer> numbers) {
		this.numbers = numbers;
		score = createScore(computer);
	}

	private Score createScore(final Computer computer) {
		int strikeCount = computer.getStrikeCount(numbers);
		int ballCount = computer.getBallCount(numbers, strikeCount);
		return new Score(strikeCount, ballCount);
	}
}
