package baseball;

import baseball.controller.BaseballGame;

public class Application {
	public static void main(String[] args) {
		final BaseballGame baseballGame = new BaseballGame();

		do {
			baseballGame.gameStart();
		} while (baseballGame.replay());
	}
}
