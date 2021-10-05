package baseball.controller;

import java.util.HashMap;

import baseball.exception.NotThreeDigitNumberException;
import baseball.service.BaseballService;
import baseball.view.BaseballView;
import nextstep.utils.Console;

public class BaseballController {
	private BaseballService baseballService = new BaseballService();
	private BaseballView baseballView = new BaseballView();
	private boolean gameOverFlag = false;

	public BaseballController() {
	}

	public void startGame() {
		baseballService.createAnswer();
		while (gameOverFlag == false) {
			String input = getInputWithoutDuplicateDigits(getThreeDigitNumberInput());
			HashMap<String, Integer> result = baseballService.returnResult(input);
			baseballView.showResultMessage(result);
			checkGameOver(result);
		}
		quitGame();
	}

	private String getInputWithoutDuplicateDigits(String input) {
		while (!baseballService.isValidInput(input)) {
			baseballView.showNumberInputErrorMessage();
			input = getThreeDigitNumberInput();
		}
		return input;
	}

	private String getThreeDigitNumberInput() {
		baseballView.showRequestInputMessage();
		String input = Console.readLine();
		try {
			baseballService.isValidInput(input);
			return input;
		} catch (NumberFormatException | NotThreeDigitNumberException e) {
			baseballView.showNumberInputErrorMessage();
			return getThreeDigitNumberInput();
		}
	}

	private void checkGameOver(HashMap<String, Integer> result) {
		if (result.get("strike") == 3) {
			baseballView.showGameOverMessage();
			gameOverFlag = true;
		}
	}

	private void quitGame() {
		this.gameOverFlag = false;
		String input = getValidGameOverInput();
		if (input.equals("1")) {
			startGame();
		}
		return;
	}

	private String getValidGameOverInput() {
		String input = Console.readLine();
		while (!input.equals("1") && !input.equals("2")) {
			baseballView.showGameOverInputErrorMessage();
			input = Console.readLine();
		}
		return input;
	}
}
