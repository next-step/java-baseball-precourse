package baseball.model;

import java.util.List;
import java.util.Objects;

import baseball.view.response.ScoreResponse;

public class Game {
	private final Computer computer;
	private GameStatus gameStatus = GameStatus.IN_PROGRESS;

	public Game(final Computer computer) {
		this.computer = computer;
	}

	public ScoreResponse getScoreResponse(final List<Integer> input) {
		Round round = startNewRound(input);
		setStatus(round.getScore());
		return new ScoreResponse(round.getScore().getScoreMessage());
	}

	public boolean isFinish() {
		return Objects.equals(gameStatus, GameStatus.GAME_OVER);
	}

	private void setStatus(final Score score) {
		if (score.getStrikeCount() == 3) {
			gameStatus = GameStatus.GAME_OVER;
		}
	}

	private Round startNewRound(final List<Integer> input) {
		return new Round(computer, input);
	}
}
