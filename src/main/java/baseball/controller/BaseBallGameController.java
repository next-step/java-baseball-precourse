package baseball.controller;

import java.util.List;

import baseball.domain.BaseballComputer;
import baseball.view.BaseballGameView;

public class BaseBallGameController {
	
	public static void start() {
		boolean playFlag = true;
		while(playFlag) {
			BaseballComputer baseballComputer = new BaseballComputer();
			play(baseballComputer);
			playFlag = BaseballGameView.checkGameStatus();
		}
	}
	
	private static void play(BaseballComputer baseballComputer) {
		while(!baseballComputer.isEnd()) {
			List<Integer> inputNumbers = BaseballGameView.readInputNumbers();
			baseballComputer.checkInput(inputNumbers);
			BaseballGameView.getResult(baseballComputer);
		}
		BaseballGameView.showGameEnd();
	}
}