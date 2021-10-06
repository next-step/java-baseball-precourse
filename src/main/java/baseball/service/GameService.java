package baseball.service;

import baseball.model.CompareResult;
import baseball.model.GameAnswer;

public class GameService {
	private final GameAnswer gameAnswer;

	public GameService(GameAnswer gameAnswer) {
		this.gameAnswer = gameAnswer;
	}

	public void generateAnswer() {
		gameAnswer.generateAnswer();
	}

	public CompareResult compareAnswer(String input) {
		int length = input.length();
		int[] userAnswer = new int[length];
		for (int i = 0; i < userAnswer.length; i++) {
			userAnswer[i] = input.charAt(i) - '0';
		}

		return gameAnswer.compare(userAnswer);
	}
}
