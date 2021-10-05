package baseball.service;

import baseball.functional.NumbersGenerator;
import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseBallGameService {
	private final NumbersGenerator numbersGenerator;

	public BaseBallGameService(NumbersGenerator numbersGenerator) {
		this.numbersGenerator = numbersGenerator;
	}

	public void startGame(Computer computer) {
		Hint hint = Hint.create();

		while (!isEndGame(hint)) {
			Player player = InputView.getPlayer();
			hint = computer.getHintFromPlayerNumbers(player);

			ResultView.print(hint);
		}
		attemptRestartGame();
	}

	private void attemptRestartGame() {
		if (InputView.isRestartGame()) {
			startGame(Computer.create(numbersGenerator));
			return;
		}

		ResultView.printGameOverMessage();
	}

	private boolean isEndGame(Hint hint) {
		return hint.isStrikeOut();
	}
}
