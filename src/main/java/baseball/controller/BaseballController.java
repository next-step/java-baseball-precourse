package baseball.controller;

import java.util.HashMap;

import baseball.exception.NotThreeDigitNumberException;
import baseball.service.BaseballService;
import baseball.view.BaseballView;
import nextstep.utils.Console;

public class BaseballController {
	private BaseballService baseballService;
	private BaseballView baseballView;
	private boolean gameOverFlag;

	public BaseballController() {
		this.baseballService = new BaseballService();
		this.baseballView = new BaseballView();
		this.gameOverFlag = false;
	}

	public void startGame() {
		while (this.gameOverFlag == false) {
			String input = this.getValidInput(getThreeDigitNumberInput());
			HashMap<String, Integer> result = baseballService.returnResult(input);
			baseballView.showResultMessage(result);
			checkGameOver(result);
		}
	}

	private String getValidInput(String input) {
		while (!baseballService.isValidInput(input)) {
			this.baseballView.showErrorMessage();
			input = this.getThreeDigitNumberInput();
		}
		return input;
	}

	private String getThreeDigitNumberInput() {
		this.baseballView.showRequestInputMessage();
		String input = Console.readLine();
		try {
			this.baseballService.isValidInput(input);
			return input;
		} catch (NumberFormatException | NotThreeDigitNumberException e) {
			this.baseballView.showErrorMessage();
			return this.getThreeDigitNumberInput();
		}
	}

	private void checkGameOver(HashMap<String, Integer> result) {
		if (result.get("strike") == 3) {
			this.baseballView.showGameOverMessage();
			this.gameOverFlag = true;
		}
	}
}
