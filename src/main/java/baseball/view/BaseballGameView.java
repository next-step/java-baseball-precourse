package baseball.view;

import baseball.controller.BaseballGameConrtoller;

public class BaseballGameView {
	private BaseballGameConrtoller baseballGameConrtoller;

	public BaseballGameView() {
		this.baseballGameConrtoller = new BaseballGameConrtoller();
	}

	public void play() {
		baseballGameConrtoller.initGame();
	}
}
