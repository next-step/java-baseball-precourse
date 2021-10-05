package baseball.controller;

import baseball.model.Computer;
import baseball.model.Game;

public class GameController {
	public void play() {
		Game game = new Game(new Computer());
	}
}
