package baseball;

import baseball.game.NumberBaseballGame;

public class Application {
	public static void main(String[] args) {
		NumberBaseballGame numberBaseballGame = NumberBaseballGame.init();
		boolean isRunning = true;

		while (isRunning) {
			isRunning = numberBaseballGame.start();
		}
	}
}
