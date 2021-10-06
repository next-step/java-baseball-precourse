package baseball;

import baseball.view.Input;
import baseball.view.Output;

public class BaseballGame {
	private BaseballNumbers playerNumbers;
	private BaseballNumbers computerNumbers;

	public void start() {
		ScoreJudgment scoreJudgment = new ScoreJudgment();
		computerNumbers = BaseballNumbersGenerator.createBaseballNumbers();
		do {
			readPlayerBaseballNumbers();
			Output.printGameResult(scoreJudgment.judgment(playerNumbers, computerNumbers));
		} while (isEndGame(playerNumbers, computerNumbers));
		Output.printEndOfGameMessage();
	}

	private void readPlayerBaseballNumbers() {
		try {
			Output.printInputNumberMessage();
			playerNumbers = BaseballNumbersGenerator.createBaseballNumbers(Input.readPlayerInput());
		} catch (IllegalArgumentException exception) {
			Output.printExceptionMessage(exception.getMessage());
			readPlayerBaseballNumbers();
		}
	}

	private boolean isEndGame(BaseballNumbers playerNumbers, BaseballNumbers computerNumbers) {
		if (playerNumbers.equals(computerNumbers)) {
			return false;
		}
		return true;
	}
}
