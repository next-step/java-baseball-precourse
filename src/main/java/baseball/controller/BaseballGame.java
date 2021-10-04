package baseball.controller;

import java.util.List;

import baseball.domain.Balls;
import baseball.domain.GameResult;
import baseball.util.ParseUtils;
import baseball.util.RandomUtils;
import baseball.util.ValidationUtils;
import baseball.view.BaseBallView;

public class BaseballGame {

	public void gameStart() {
		// TODO create Computer Rule
		final Balls computerBalls = new Balls(createComputerBalls(1, 9, 3));
		play(computerBalls);
	}

	private void play(Balls computerBalls) {
		GameResult gameResult;

		do {
			final Balls playerBalls = new Balls(solveInput());
			gameResult = computerBalls.play(playerBalls);
			solveOutput(gameResult.resultMsg());
		} while (gameResult.isNotFinished());
	}

	private void solveOutput(String resultMsg) {
		BaseBallView.printResult(resultMsg);
	}

	private List<Integer> createComputerBalls(final int startInclusive, final int endInclusive, final int resultSize) {
		return RandomUtils.generateNoDuplicateNumbers(startInclusive, endInclusive, resultSize);
	}

	private List<Integer> solveInput() {
		String input;

		do {
			input = BaseBallView.requestInputNumber();
		} while (isInvalidInput(input));

		return ParseUtils.toIntList(input);
	}

	private boolean isInvalidInput(String input) {
		try {
			ValidationUtils.validateInput(input);
		} catch (IllegalArgumentException e) {
			BaseBallView.printResult(e.getMessage());
			return true;
		}

		return false;
	}
}
