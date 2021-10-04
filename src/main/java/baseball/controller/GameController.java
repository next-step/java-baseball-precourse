package baseball.controller;

import java.util.List;

import baseball.model.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

	private final InputView inputView;
	private final OutputView outputView;

	public GameController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void play() {
		boolean isContinue;
		do {
			isContinue = playRound();
		} while (isContinue);

		this.outputView.printGameEnd();
	}

	private boolean playRound() {
		BaseballGame game = startGame();
		do {
			game = game.hit(readInputNumbers(this.outputView::printInputNumber));
			this.outputView.printGameResult(game.getBallCount());
		} while (!game.isFinished());

		roundEndAndRestartCheck();
		return this.inputView.inputEndNumber();
	}

	private List<Integer> readInputNumbers(Runnable outputRunner) {
		outputRunner.run();
		try {
			return this.inputView.inputNumbers();
		} catch (NumberFormatException e) {
			this.outputView.printUserInputError();
			return readInputNumbers(outputRunner);
		}
	}

	private void roundEndAndRestartCheck() {
		this.outputView.printRoundEnd();
		this.outputView.printRestartCheck();
	}

	private BaseballGame startGame() {
		return new BaseballGame();
	}
}
