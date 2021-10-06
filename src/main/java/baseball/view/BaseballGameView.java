package baseball.view;

import baseball.controller.BaseballGameConrtoller;
import nextstep.utils.Console;

public class BaseballGameView {
	private BaseballGameConrtoller baseballGameConrtoller;

	public BaseballGameView() {
		this.baseballGameConrtoller = new BaseballGameConrtoller();
	}

	public void play() {
		String result;
		baseballGameConrtoller.initGame();
		do {
			result = baseballGameConrtoller.submitBallNumberStr(Console.readLine());
		} while (result.equals("InvalidBallNumberException"));
	}
}
