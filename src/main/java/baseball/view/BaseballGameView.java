package baseball.view;

import baseball.controller.BaseballGameConrtoller;
import nextstep.utils.Console;

public class BaseballGameView {
	private BaseballGameConrtoller baseballGameConrtoller;

	public BaseballGameView() {
		this.baseballGameConrtoller = new BaseballGameConrtoller();
	}

	public void play() {
		baseballGameConrtoller.initGame();
		baseballGameConrtoller.submitBallNumberStr(Console.readLine());
	}
}
