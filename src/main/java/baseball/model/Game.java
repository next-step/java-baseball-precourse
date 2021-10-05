package baseball.model;

import java.util.List;

import baseball.view.response.ScoreResponse;

public class Game {
	private final Computer computer;

	public Game(final Computer computer) {
		this.computer = computer;
	}

	public ScoreResponse getScoreResponse(final List<Integer> input) {
		Round round = startNewRound(input);
		return new ScoreResponse(round.getScore().getScoreMessage());
	}

	private Round startNewRound(final List<Integer> input) {
		return new Round(computer, input);
	}
}
