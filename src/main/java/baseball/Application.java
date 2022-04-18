package baseball;

import baseball.logic.BaseBallGameLogic;
import baseball.ui.CliGameUI;
import baseball.ui.GameUI;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		GameUI gameUI = new CliGameUI(new BaseBallGameLogic());
		gameUI.start();
	}
}
