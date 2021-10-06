package baseball.controller;

import java.util.List;

import baseball.model.OpponentBaseballNumber;
import baseball.model.PlayerBaseballNumber;
import baseball.view.GameResultView;
import baseball.view.PlayerInputView;
import baseball.view.RestartSelectView;

public class BaseballGameStarter {

	public static void startGame() {

		OpponentBaseballNumber opponentBaseballNumber = new OpponentBaseballNumber(
			(List<Integer>)OpponentBaseballNumberGenerator.generateOpponentBaseBallNumber()
		);
		boolean isKeepGoing = true;

		do{
			PlayerBaseballNumber playerBaseballNumber = PlayerInputView.inputBaseballNumber();
			CheckBaseballNumberWithRule.checkBaseballNumber(opponentBaseballNumber, playerBaseballNumber);
			GameResultView.printGameRoundResult(playerBaseballNumber);

			if(playerBaseballNumber.getStrikeCount() == 3)
				isKeepGoing = false;
		}while(isKeepGoing);

		selectRestart();
	}

	private static void selectRestart() {

		if(RestartSelectView.printRestartSelectMessage())
			startGame();
	}
}
