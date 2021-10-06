package baseball.controller;

import baseball.model.CompareResult;
import baseball.service.GameService;
import baseball.view.GameView;

public class GameController {
	private final GameView gameView;
	private final GameService gameService;

	public GameController(GameView gameView, GameService gameService) {
		this.gameView = gameView;
		this.gameService = gameService;
	}

	public void index() {
		do {
			restartGame();
		} while (isResume());
	}

	public void restartGame() {
		gameService.generateAnswer();
		boolean isAnswer = false;
		do {
			isAnswer = requestAnswer();
		} while (!isAnswer);
	}

	public boolean isResume() {
		String input = gameView.InputMenuMessage();
		return "1".equals(input);
	}

	public boolean requestAnswer() {
		String input = gameView.inputAnswerMessage();
		CompareResult compareResult = gameService.compareAnswer(input);

		return compareResult.isAnswer();
	}
}
