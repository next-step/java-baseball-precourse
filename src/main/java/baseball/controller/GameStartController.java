package baseball.controller;

import baseball.model.BallCount;
import baseball.model.UserInputValue;
import baseball.view.InputView;

public class GameStartController {

	private static final String THREE_STRIKE = "3스트라이크";
	
	public static void startGame(int randomValue) {
		
		String strikeAndBallResult = "";
		
		while(!strikeAndBallResult.equals(THREE_STRIKE)) {
			int userInputNumber = numberException();
			strikeAndBallResult = BallCount.checkStrikeAndBall(randomValue, userInputNumber);
			
			System.out.println(strikeAndBallResult);
		}
	}
	
	private static int numberException() {
		String errCode = "ERROR";
		int inputNumber = 0;
		
		while(errCode.equals("ERROR")) {
			inputNumber = UserInputValue.getUserInput(InputView.getInput());
			errCode = UserInputValue.getErrCode();
		}
		
		return inputNumber;
	}
}
