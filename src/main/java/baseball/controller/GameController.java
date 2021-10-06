package baseball.controller;

import static baseball.view.ConsoleLog.*;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.view.request.NumberRequest;

public class GameController {
	public void play() {
		Game game = new Game(new Computer());
		while (!game.isFinish()) {
			NumberRequest request = getInputRequest();
			printScore(game.getScoreResponse(request.getNumbers()));
		}
		printGameClear();
	}

	private NumberRequest getInputRequest() {
		try {
			return getInputNumber();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getInputRequest();
		}
	}
}
