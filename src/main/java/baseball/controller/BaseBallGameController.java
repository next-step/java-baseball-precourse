package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Hint;
import baseball.domain.Player;
import baseball.generator.NumbersGenerator;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseBallGameController {
	private final NumbersGenerator numbersGenerator;

	private BaseBallGameController(NumbersGenerator numbersGenerator) {
		this.numbersGenerator = numbersGenerator;
	}

	public static BaseBallGameController create(NumbersGenerator numbersGenerator) {
		return new BaseBallGameController(numbersGenerator);
	}

	public void start() {
		Computer computer = Computer.create(numbersGenerator);
		Hint hint;
		do {
			Player player = InputView.getPlayer();
			hint = computer.getHintFromPlayerNumbers(player);

			ResultView.print(hint);
		} while (!isEndGame(hint));

		attemptRestartGame();
	}

	private boolean isEndGame(Hint hint) {
		return hint.isStrikeOut();
	}

	private void attemptRestartGame() {
		if (InputView.isRestartGame()) {
			start();
			return;
		}

		ResultView.printGameOverMessage();
	}
}
