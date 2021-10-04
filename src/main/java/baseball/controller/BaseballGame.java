package baseball.controller;

import baseball.util.ValidationUtils;
import baseball.view.BaseBallView;

public class BaseballGame {

	public void play() {
		final String input = solveInput();
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
