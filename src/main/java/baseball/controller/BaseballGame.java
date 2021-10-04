package baseball.controller;

import java.util.List;

import baseball.util.ParseUtils;
import baseball.util.RandomUtils;
import baseball.util.ValidationUtils;
import baseball.view.BaseBallView;

public class BaseballGame {

	public void play() {
		// TODO create Computer Rule
		final List<Integer> computerBalls = createComputerBalls(1, 9, 3);
		final List<Integer> playerBalls = ParseUtils.toIntList(solveInput());
	}

	private List<Integer> createComputerBalls(final int startInclusive, final int endInclusive, final int resultSize) {
		return RandomUtils.generateNoDuplicateNumbers(startInclusive, endInclusive, resultSize);
	}

	private String solveInput() {
		String input;

		do {
			input = BaseBallView.requestInputNumber();
		} while (isInvalidInput(input));

		return input;
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
