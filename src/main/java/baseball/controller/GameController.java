package baseball.controller;

import static baseball.utils.Hint.*;

import baseball.domain.BallNumbers;
import baseball.domain.Computer;
import baseball.domain.Judge;
import baseball.view.GameInput;
import baseball.view.GameOutput;

public class GameController {

	private final GameInput inputView;
	private final GameOutput outputView;

	public GameController() {
		this.inputView = new GameInput();
		this.outputView = new GameOutput();
	}

	public void play() {
		Computer computer = new Computer();
		do {
			BallNumbers computerNumbers = computer.makeRandomNumbers();
			gameJudge(computerNumbers);
		} while (inputView.isRestart());
	}

	private void gameJudge(BallNumbers computerNumbers) {
		Judge judge;
		do {
			judge = new Judge();
			BallNumbers userNumbers = isValidInput(inputView.inputMessage());
			judge.countContainNumbers(computerNumbers, userNumbers);
			printNothing(judge);
		} while(judge.strikeCount() != 3);
		outputView.print(GAME_END.getHint());
	}

	private BallNumbers isValidInput(String input) {
		try {
			Integer.parseInt(input);
			BallNumbers.of(input);
		} catch (IllegalArgumentException e) {
			outputView.print(ERROR.getHint());
		}
		return BallNumbers.of(input);
	}

	private void printNothing(Judge judge) {
		String message = "";
		if (judge.isNothing()) {
			message = NOTHING.getHint();
		}
		printHint(judge, message);
	}

	private void printHint(Judge judge, String message) {
		if (judge.strikeCount() > 0) {
			message = STRIKE.getHint(judge.strikeCount());
		}
		if (judge.ballCount() > 0) {
			message += BALL.getHint(judge.ballCount());
		}
		outputView.print(message);
	}
}
