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
		while (true) {
			System.out.print("숫자를입력해주세요 : ");
			result = baseballGameConrtoller.submitBallNumberStr(Console.readLine());
			if (!result.equals("InvalidBallNumberException")) {
				break;
			}
			System.out.println("[ERROR] InvalidBallNumberException");
		}
	}
}
