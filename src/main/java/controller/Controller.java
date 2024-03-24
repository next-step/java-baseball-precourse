package controller;

import java.util.Scanner;

import model.Game;
import validator.InputValidator;

public class Controller {
	private final Game game = new Game();

	private final Scanner scanner = new Scanner(System.in);

	public void play() {
		while (!game.status.isFinish()) {
			getInput();
			if (game.status.isFinish() && decideRestart()) {
				game.initGame();
			}
		}
	}

	public void getInput() {
		while (true) {
			try {
				view.InputView.displayInputMessage();
				String input = scanner.nextLine();
				validator.InputValidator.validateAnswerInput(input);
				game.updateCount(input);
				view.OutputView.displayCount(game.status.getStrikeCount(), game.status.getBallCount());
				break;
			} catch (IllegalArgumentException e) {
				view.OutputView.displayErrorMessage(e.getMessage());
			}
		}
	}

	public boolean decideRestart() {
		view.OutputView.displayEndMessage();
		while (true) {
			try {
				view.InputView.displayRestartMessage();
				String input = scanner.nextLine();
				validator.InputValidator.validateRestartInput(input);
				return input.equals(InputValidator.RESTART_CODE);
			} catch (IllegalArgumentException e) {
				view.OutputView.displayErrorMessage(e.getMessage());
			}
		}
	}
}
